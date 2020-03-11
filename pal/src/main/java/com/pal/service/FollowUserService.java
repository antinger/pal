package com.pal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.FollowUserDao;
import com.pal.entity.FollowUser;
import com.pal.entity.HostHolder;
import com.pal.entity.User;

@Service
public class FollowUserService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	FollowUserDao followUserDao;

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
	
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}

}
