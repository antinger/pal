package com.pal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.UserDao;
import com.pal.dao.VisitorDao;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.ViewObject;
import com.pal.entity.Visitor;

@Service
public class VisitorService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	VisitorDao visitorDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	QiniuService qiniuService;

	//关注
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
	
	//获取我关注的人
	public Map<String, Object> getVistor() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		List<Visitor> visitors = visitorDao.getVistor(user.getId());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (Visitor visitor : visitors) {
			ViewObject view = new ViewObject();
			User temp = userDao.selectUserByID(visitor.getUserID());
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
