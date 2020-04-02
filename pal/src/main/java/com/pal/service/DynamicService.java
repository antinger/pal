package com.pal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pal.dao.DynamicDao;
import com.pal.dao.MemberTicketDao;
import com.pal.dao.UserDao;
import com.pal.entity.Dynamic;
import com.pal.entity.HostHolder;
import com.pal.entity.MemberTicket;
import com.pal.entity.User;
import com.pal.entity.ViewObject;
import com.pal.utils.PalUtils;

@Service
public class DynamicService {

	@Autowired
	DynamicDao dynamicDao;
	
	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	MemberTicketDao memberTicketDao;
	
	//获取动态
	public Map<String, Object> getLaterDynamic(Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(page > 2) {
			MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(getThreadUser().getUsername());
			if(memberTicket == null) {
				map.put("member", true);
				return map;
			}
			if(memberTicket.getCreateDate().getTime() > memberTicket.getExpired().getTime() || memberTicket.getStatus() == 1) {
				map.put("member", true);
				return map;
			}
		}
		int status = 0;
		int start = (page - 1) * limit;
		User threadUser = getThreadUser();
		int sex = threadUser.getSex() == 0 ? 1 : 0;
		//获取数据
		List<Dynamic> dynamics = dynamicDao.getLaterDynamic(start, limit, sex, status);
		//获取一共有多少条数据
		int count = dynamicDao.getLaterDynamicCount(status);
		//获取总页数
		int pageCount = (count - 1) / limit + 1;
		//包装数据
		dealBynamic(dynamics, map);
		map.put("pageCount", pageCount);
		return map;
	}
	
	//数据保装
	private void dealBynamic(List<Dynamic> dynamics, Map<String, Object> map) {
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (Dynamic dynamic : dynamics) {
			ViewObject view = new ViewObject();
			if(!"".equals(dynamic.getImage())) {
				dynamic.setImage(qiniuService.dealOnlyImage(dynamic.getImage()));
			}
			User user = userDao.selectUserByID(dynamic.getUserID());
			if(!"".equals(user.getHeadLink())) {
				user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
			}
			view.setView("dynamic", dynamic);
			view.setView("user", user);
			view.setView("createDate", PalUtils.formatDate(dynamic.getCreateDate()));
			data.add(view);
		}
		map.put("data", data);
	}

	//添加动态
	public Map<String, Object> addDynamic(String content, MultipartFile image) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		Dynamic dynamic = new Dynamic();
		if(image != null) {
			Map<String, Object> saveImage = qiniuService.saveImage(image);
			dynamic.setImage(saveImage.get("fileList").toString());
		}
		dynamic.setUserID(threadUser.getId());
		dynamic.setSex(threadUser.getSex());
		dynamic.setStatus(1);
		dynamic.setContent(content);
		dynamicDao.addDynamic(dynamic);
		map.put("message", "发布成功");
		return map;
	}
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}

	//审核状态
	public Map<String, Object> updateDynamic(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		dynamicDao.updateDynamic(id, 0);
		map.put("message", "审核成功");
		return map;
	}
	
	public Map<String, Object> getDynamicByUserID(Integer userID) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dynamic> dynamics = dynamicDao.getDynamicByUserID(userID, 0);
		dealBynamic(dynamics, map);
		return map;
	}

}
