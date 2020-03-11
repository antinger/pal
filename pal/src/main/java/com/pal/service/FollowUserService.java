package com.pal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.FollowUserDao;
import com.pal.dao.UserDao;
import com.pal.entity.FollowUser;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.ViewObject;

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
			if(temp.getHeadStatus() == 0) {
				temp.setHeadLink(qiniuService.dealOnlyImage(temp.getHeadLink()));
			}
			view.setView("user", temp);
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	//获取粉丝
	public Map<String, Object> getFans() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		List<FollowUser> followUsers = followUserDao.getFans(user.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (FollowUser followUser : followUsers) {
			ViewObject view = new ViewObject();
			User temp = userDao.selectUserByID(followUser.getUserID());
			if(temp.getHeadStatus() == 0) {
				temp.setHeadLink(qiniuService.dealOnlyImage(temp.getHeadLink()));
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

}
