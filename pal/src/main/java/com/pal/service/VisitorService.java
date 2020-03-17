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
import com.pal.dao.VisitorDao;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.UserInfo;
import com.pal.entity.ViewObject;
import com.pal.entity.Visitor;
import com.pal.utils.PalUtils;

@Service
public class VisitorService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	VisitorDao visitorDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	FollowUserDao followUserDao;

	//添加游客
	public Map<String, Object> addVisitor(Integer visitorID) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		Visitor vistor = new Visitor();
		vistor.setUserID(user.getId());
		vistor.setVisitorID(visitorID);
		visitorDao.addVistor(vistor);
		map.put("message", "访问成功");
		return map;
	}
	
	//获取我的游客
	public Map<String, Object> getVistor() {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<Visitor> visitors = visitorDao.getVistor(threadUser.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (Visitor visitor : visitors) {
			ViewObject view = new ViewObject();
			User temp = userDao.selectUserByID(visitor.getUserID());
			setUserInfo(view, temp);
			view.setView("user", temp);
			view.setView("follow", false);
			if(followUserDao.getFollowUserByUserID(temp.getId(), threadUser.getId()) != null) {
				view.setView("follow", true);
			}
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
