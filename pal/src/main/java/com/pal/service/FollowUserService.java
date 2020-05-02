package com.pal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.FollowUserDao;
import com.pal.dao.MemberTicketDao;
import com.pal.dao.UserDao;
import com.pal.dao.UserInfoDao;
import com.pal.entity.FollowUser;
import com.pal.entity.HostHolder;
import com.pal.entity.MemberTicket;
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
	MemberTicketDao memberTicketDao;

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
		User user = getThreadUser();
		List<FollowUser> followUsers = followUserDao.getFollowUser(user.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (FollowUser followUser : followUsers) {
			ViewObject view = new ViewObject();
			User temp = userDao.selectUserByID(followUser.getFollowUserID());
			setUserInfo(view, temp);
			view.setView("user", temp);
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	//获取粉丝
	public Map<String, Object> getFans() {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(getThreadUser().getUsername());
		if(memberTicket == null) {
			map.put("member", true);
			return map;
		}
		if(memberTicket.getExpired().getTime() < new Date().getTime() || memberTicket.getStatus() == 1) {
			map.put("member", true);
			return map;
		}
		User threadUser = getThreadUser();
		List<FollowUser> followUsers = followUserDao.getFans(threadUser.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (FollowUser followUser : followUsers) {
			ViewObject view = new ViewObject();
			User temp = userDao.selectUserByID(followUser.getUserID());
			setUserInfo(view, temp);
			view.setView("follow", false);
			if(followUserDao.getFollowUserByUserID(temp.getId(), threadUser.getId()) != null) {
				view.setView("follow", true);
			}
			view.setView("user", temp);
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}
	
	private void setUserInfo(ViewObject view, User user) {
		UserInfo userInfo = userInfoDao.selectByUsername(user.getUsername());
		view.setView("birthday", PalUtils.formatBirth(userInfo.getBirthday()));
		view.setView("sex", user.getSex() == 0 ? "男" : "女");
		if(user.getHeadStatus() == 0) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
	}

}
