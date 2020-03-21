package com.pal.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.UserDao;
import com.pal.dao.UserInfoDao;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.UserInfo;
import com.pal.entity.ViewObject;
import com.pal.utils.PalUtils;

@Service
public class UserInfoService {

	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	UserDao userDao;
	
	//获取用户信息
	public Map<String, Object> getUserInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = hostHolder.getUser();
		dealUser(user, map);
		return map;
	}
	
	//根据用户名获取信息
	public Map<String, Object> getUserInfoByID(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userDao.selectUserByID(id);
		dealUser(user, map);
		return map;
	}
	
	//包装用户信息
	private void dealUser(User user, Map<String, Object> map) {
		if(!"".equals(user.getHeadLink())) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
		map.put("user", user);
		UserInfo userInfo = userInfoDao.selectByUsername(user.getUsername());
		ViewObject view = new ViewObject();
		view.setView("info", userInfo);
		view.setView("birthday", PalUtils.formatBirth(userInfo.getBirthday()));
		map.put("userInfo", view);
	}
	
	//更新用户信息
	public Map<String, Object> updateUserInfo(String education,String height,String weight,String job,String country,String town) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(hostHolder.getUser().getUsername());
		userInfo.setEducation(education);
		userInfo.setHeight(height);
		userInfo.setWeight(weight);
		userInfo.setJob(job);
		userInfo.setCountry(country);
		userInfo.setTown(town);
		userInfoDao.updateUserInfo(userInfo);
		map.put("message", "更新成功");
		return map;
	}

}
