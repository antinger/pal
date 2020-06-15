package com.pal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pal.dao.FollowUserDao;
import com.pal.dao.LoginTicketDao;
import com.pal.dao.MemberTicketDao;
import com.pal.dao.UserDao;
import com.pal.dao.UserInfoDao;
import com.pal.dao.WalletDao;
import com.pal.entity.FollowUser;
import com.pal.entity.HostHolder;
import com.pal.entity.LoginTicket;
import com.pal.entity.MemberTicket;
import com.pal.entity.User;
import com.pal.entity.UserInfo;
import com.pal.entity.ViewObject;
import com.pal.entity.Wallet;
import com.pal.utils.PalUtils;

@Service
public class UserService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	LoginTicketDao loginTicketDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	WalletDao walletDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	QiniuService qiniuService;

	@Autowired
	FollowUserDao followUserDao;
	
	@Autowired
	MemberTicketDao memberTicketDao;
	
	@Autowired
	VisitorService visitorService;
	
	//注册
	public Map<String, Object> register(String username, String password, String email, Date birthday, Integer sex, String ip) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(username == null || "".equals(username)) {
			map.put("eor", "用户名不能为空");
			return map;
		}
		if(email == null || "".equals(email)) {
			map.put("eor", "邮箱不能为空");
			return map;
		}
		if(!PalUtils.emailFormat(email)) {
			map.put("emailErr", "邮箱格式不正确");
			return map;
		}
		if(birthday == null) {
			map.put("eor", "生日不能为空");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("eor", "密码不能为空");
			return map;
		}
		if(password.length() <6) {
			map.put("password", "密码至少需要六位数");
			return map;
		}
		User user = userDao.selectUserByUsername(username);
		if(user != null) {
			map.put("name", "用户名已经注册");
			return map;
		}
		user = userDao.selectUserByEmail(email);
		if(user != null) {
			map.put("email", "邮箱已经注册");
			return map;
		}
		user = new User();
		String salt = PalUtils.getRandomUUID().substring(0, 6);
		user.setSalt(salt);
		user.setUsername(username);
		user.setPassword(PalUtils.MD5(password + salt));
		user.setEmail(email);
		user.setSex(sex);
		int status = (sex == 1) ? 1 : 0;
		user.setStatus(status);
		user.setAddress(ip);
		userDao.addUser(user);
		//添加信息
		addInfo(username, birthday);
		//添加钱包
		addWallet(username);
		String ticket = addTicket(username);
		map.put("ticket", ticket);
		map.put("message", "注册成功");
		return map;
	}
	
	//登录
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(username == null || "".equals(username)) {
			map.put("name", "用户名不能为空");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("password", "密码不能为空");
			return map;
		}
		if(password.length() <6) {
			map.put("eor", "密码至少需要六位数");
			return map;
		}
		User user = userDao.selectUserByUsername(username);
		if(user == null) {
			map.put("name", "用户名未注册");
			return map;
		}
		if(!user.getPassword().equals(PalUtils.MD5(password + user.getSalt()))) {
			map.put("password", "密码不正确");
			return map;
		}
		if(user.getStatus() == 1) {
			map.put("eor", "fail");
			return map;
		}
		//更新用户登录时间
		userDao.updateDate(user.getId(), new Date());
		userDao.updateOnLineStatus(user.getId(), 0);
		LoginTicket loginTicket = loginTicketDao.selectByUsername(username);
		//更新令牌状态
		updateLoginTicketStatus(0, username);
		updateLoginTicketExpired(username);
		map.put("ticket", loginTicket.getTicket());
		return map;
	}
	
	//退出令牌
	public Map<String, Object> logout() {
		String username = getThreadUser().getUsername();
		updateLoginTicketStatus(1, username);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "退出成功");
		return map;
	}
	
	//添加令牌
	private String addTicket(String username) {
		String ticket = PalUtils.getRandomUUID();
		long expired = new Date().getTime() + 1000 * 3600 * 24 * 2;
		LoginTicket loginTicket = new LoginTicket();
		loginTicket.setUsername(username);
		loginTicket.setTicket(ticket);
		loginTicket.setExpired(new Date(expired));
		loginTicketDao.addTicket(loginTicket);
		return ticket;
	}
	
	//更新令牌状态
	private void updateLoginTicketStatus(Integer status, String username) {
		loginTicketDao.updateStatus(username, status);
	}
	
	//登录成功,更新令牌有效期
	private void updateLoginTicketExpired(String username) {
		long expired = new Date().getTime() + 1000 * 3600 * 24 * 2;
		Date time = new Date(expired);
		loginTicketDao.updateExpired(username, time);
	}
	
	//添加用户信息
	private void addInfo(String username, Date birthday) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(username);
		userInfo.setBirthday(birthday);
		userInfoDao.addUserInfo(userInfo);
	}
	
	//添加用户钱包
	private void addWallet(String username) {
		Wallet wallet = new Wallet();
		wallet.setUsername(username);
		walletDao.addWallet(wallet);
	}

	//获取推送的用户
	public Map<String, Object> getPushUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> users = userDao.getPushUsers(0, 1, 0);
		List<User> data = new ArrayList<User>();
		for (User user : users) {
			dealUserHeadLink(user);
			data.add(user);
		}
		map.put("data", data);
		return map;
	}
	
	//获取首页推荐用户
	public Map<String, Object> getLaterUser(int page, int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(page > 2) {
			MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(getThreadUser().getUsername());
			if(memberTicket == null) {
				map.put("member", true);
				return map;
			}
			if(memberTicket.getExpired().getTime() < new Date().getTime() || memberTicket.getStatus() == 1) {
				map.put("member", true);
				return map;
			}
		}
		int start = (page - 1) * limit;
		User threadUser = getThreadUser();
		Integer sex = threadUser.getSex();
		Integer target = sex == 0 ? 1 : 0;
		List<User> users = new ArrayList<>();
		users.addAll(userDao.getLaterUser(0, target, start, limit));
		List<ViewObject> data = new ArrayList<ViewObject>();
		Integer count = userDao.getLaterUserCount(0, sex);
		int pageCount = (count - 1) / limit + 1;
		for (User user : users) {
			if(user.getUsername().equals("Service")) {
				continue ;
			}
			ViewObject view = new ViewObject();
			dealUser(user, threadUser, view);
			data.add(view);
		}
		if(page == 1) {
			User user = userDao.selectUserByUsername("Service");
			if(user != null) {
				ViewObject view = new ViewObject();
				dealUser(user, threadUser, view);
				data.add(0, view);
			}
		}
		map.put("data", data);
		map.put("pageCount", pageCount);
		return map;
	}
	
	private void dealUser(User user, User threadUser, ViewObject view) {
		if(user.getUsername().equals(threadUser.getUsername())) {
			return ;
		}
		dealUserHeadLink(user);
		view.setView("user", user);
		UserInfo userInfo = userInfoDao.selectByUsername(user.getUsername());
		if(new Date().getTime() - user.getUpdateDate().getTime() > 1000 * 3600 * 24 * 2) {
			userDao.updateOnLineStatus(user.getId(), 1);
			user.setOnLineStatus(1);
		}
		view.setView("info", userInfo);
		view.setView("sex", user.getSex() == 0 ? "男" : "女");
		view.setView("birthday", PalUtils.formatBirth(userInfo.getBirthday()));
		view.setView("follow", false);
		dealMember(view, user.getUsername());
		FollowUser followUser = followUserDao.getFollowUserByUserID(threadUser.getId(), user.getId());
		if(followUser != null) {
			view.setView("follow", true);
		}
	}
	
	//处理用户头像
	private void dealUserHeadLink(User user) {
		if(user.getHeadStatus() == 0 && !"".equals(user.getHeadLink())) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
	}
	
	//获取当前线程对象
	private User getThreadUser() {
		return hostHolder.getUser();
	}

	//更新密码
	public Map<String, Object> updatePassword(String password, String oldPassword) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(oldPassword == null || "".equals(oldPassword)) {
			map.put("oldPassword", "原密码不能为空");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("password", "新密码不能为空");
			return map;
		}
		if(password.length() <6) {
			map.put("password", "密码至少需要六位数");
			return map;
		}
		User user = getThreadUser();
		if(!user.getPassword().equals(PalUtils.MD5(oldPassword + user.getSalt()))) {
			map.put("password", "原密码不正确");
			return map;
		}
		userDao.updatePassword(user.getId(), PalUtils.MD5(password + user.getSalt()));
		map.put("message", "更新成功");
		return map;
	}
	
	//更新头像
	public Map<String, Object> updateHeadLink(MultipartFile image) throws IOException {
		Map<String, Object> map = qiniuService.saveImage(image);
		User user = getThreadUser();
		userDao.updateHeadLink(user.getId(), map.get("fileList").toString(), 1);
		map.clear();
		map.put("message", "更新成功");
		return map;
	}
	
	public Map<String, Object> getUserByUsername(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		if(threadUser.getUsername() == username) {
			return map;
		}
		User user = userDao.selectUserByUsername(username);
		if(user != null) {
			if(threadUser.getUsername() == username) {
				return map;
			}
			visitorService.addVisitor(user.getId());
			dealUserHeadLink(user);
			map.put("user", user);
		} else {
			map.put("message", "fail");
		}
		return map;
	}
	
	private void dealMember(ViewObject view, String username) {
		MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(username);
		if(memberTicket != null) {
			if(memberTicket.getExpired().getTime() > new Date().getTime() && memberTicket.getStatus() == 0) {
				view.setView("member", memberTicket.getGrade());
			}
		}
	}

	public Map<String, Object> updateOnLineStatus(Integer onLineStatus) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		userDao.updateOnLineStatus(threadUser.getId(), onLineStatus);
		return map;
	}

	public Map<String, Object> updateHeadLinkH5(String image) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		userDao.updateHeadLink(user.getId(), image, 1);
		map.clear();
		map.put("message", "更新成功");
		return map;
	}
	
}
