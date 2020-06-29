package com.pal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.FollowUserDao;
import com.pal.dao.UserDao;
import com.pal.dao.UserInfoDao;
import com.pal.entity.FollowUser;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.UserInfo;
import com.pal.entity.ViewObject;
import com.pal.utils.PalUtils;

@Service
public class FollowUserService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	FollowUserDao followUserDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	MemberTicketService memberTicketService;

	//关注
	public Map<String, Object> follow(Integer followUserID) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		FollowUser followUser = new FollowUser();
		followUser.setFollowUserID(followUserID);
		followUser.setUserID(user.getId());
		followUserDao.addFollowUser(followUser);
		map.put("message", "关注成功");
		return map;
	}
	
	//获取我关注的人
	public Map<String, Object> getFollowUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<FollowUser> followUsers = followUserDao.getFollowUser(threadUser.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (FollowUser followUser : followUsers) {
			ViewObject view = new ViewObject();
			User user = userDao.selectUserByID(followUser.getFollowUserID());
			dealUserInfo(view, user);
			view.setView("user", user);
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	//获取粉丝
	public Map<String, Object> getFans() {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean flag = memberTicketService.isMemberTicket();
		if(!flag) {
			map.put("member", true);
			return map;
		}
		User threadUser = getThreadUser();
		List<FollowUser> followUsers = followUserDao.getFans(threadUser.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (FollowUser followUser : followUsers) {
			ViewObject view = new ViewObject();
			dealFollowUser(followUser, view, threadUser);
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	//处理关注的用户
	private void dealFollowUser(FollowUser followUser, ViewObject view, User threadUser) {
		User user = userDao.selectUserByID(followUser.getUserID());
		dealUserInfo(view, user);
		isFollow(view, user, threadUser);
		view.setView("user", user);
	}
	
	//是否相互关注
	private void isFollow(ViewObject view, User user, User threadUser) {
		view.setView("follow", false);
		if(followUserDao.getFollowUserByUserID(user.getId(), threadUser.getId()) != null) {
			view.setView("follow", true);
		}
	}
	
	//处理显示信息
	private void dealUserInfo(ViewObject view, User user) {
		UserInfo userInfo = userInfoDao.selectByUsername(user.getUsername());
		view.setView("birthday", PalUtils.formatBirth(userInfo.getBirthday()));
		view.setView("sex", user.getSex() == 0 ? "男" : "女");
		if(user.getHeadStatus() == 0) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
	}

	private User getThreadUser() {
		return hostHolder.getUser();
	}
}
