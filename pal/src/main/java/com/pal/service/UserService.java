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

import com.pal.dao.LoginTicketDao;
import com.pal.dao.UserDao;
import com.pal.dao.UserInfoDao;
import com.pal.dao.WalletDao;
import com.pal.entity.HostHolder;
import com.pal.entity.LoginTicket;
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

	//注册
	public Map<String, Object> register(String username, String password, String email, Date birthday, Integer sex, String ip) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(username == null || "".equals(username)) {
			map.put("username", "用户名不能为空");
			return map;
		}
		if(email == null || "".equals(email)) {
			map.put("email", "邮箱不能为空");
			return map;
		}
		if(birthday == null) {
			map.put("birthday", "生日不能为空");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("password", "密码不能为空");
			return map;
		}
		if(password.length() <6) {
			map.put("password", "密码至少需要六位数");
			return map;
		}
		User user = userDao.selectUserByUsername(username);
		if(user != null) {
			map.put("username", "用户名已经注册");
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
		return map;
	}
	
	//登录
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(username == null || "".equals(username)) {
			map.put("username", "用户名不能为空");
			return map;
		}
		if(password == null || "".equals(password)) {
			map.put("password", "密码不能为空");
			return map;
		}
		if(password.length() <6) {
			map.put("password", "密码至少需要六位数");
			return map;
		}
		User user = userDao.selectUserByUsername(username);
		if(user == null) {
			map.put("username", "用户名未注册");
			return map;
		}
		if(!user.getPassword().equals(PalUtils.MD5(password + user.getSalt()))) {
			map.put("password", "密码不正确");
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
		long expired = new Date().getTime() + 1000 * 3600 * 24 *10;
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
		long expired = new Date().getTime() + 1000 * 3600 * 24 * 10;
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
	public Map<String, Object> getLaterUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		Integer sex = threadUser.getSex();
		Integer target = sex == 0 ? 1 : 0;
		List<User> users = userDao.getLaterUser(0, target);
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (User user : users) {
			dealUserHeadLink(user);
			ViewObject view = new ViewObject();
			view.setView("user", user);
			UserInfo userInfo = userInfoDao.selectByUsername(user.getUsername());
			view.setView("info", userInfo);
			view.setView("sex", user.getSex() == 0 ? "男" : "女");
			view.setView("birthday", PalUtils.formatDate(userInfo.getBirthday()));
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	//处理用户头像
	private void dealUserHeadLink(User user) {
		user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
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
		userDao.updateHeadLink(user.getId(), map.get("fileList").toString());
		map.clear();
		map.put("message", "更新成功");
		return map;
	}
	
}
