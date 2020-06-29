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
import com.pal.entity.Dynamic;
import com.pal.entity.HostHolder;
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
	HostHolder hostHolder;
	
	@Autowired
	MemberTicketService memberTicketService;
	
	@Autowired
	UserService userService;
	
	
	//获取动态
	public Map<String, Object> getLaterDynamic(Integer page, Integer limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(page > 2) {
			boolean flag = memberTicketService.isMemberTicket();
			if(!flag) {
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
		packData(dynamics, map);
		map.put("pageCount", pageCount);
		return map;
	}
	
	//数据保装
	private void packData(List<Dynamic> dynamics, Map<String, Object> map) {
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (Dynamic dynamic : dynamics) {
			ViewObject view = new ViewObject();
			dealDynamic(dynamic, view);
			userService.dealUser(dynamic.getUserID(), view);
			data.add(view);
		}
		map.put("data", data);
	}
	
	//处理动态
	private void dealDynamic(Dynamic dynamic, ViewObject view) {
		if(!"".equals(dynamic.getImage())) {
			dynamic.setImage(qiniuService.dealOnlyImage(dynamic.getImage()));
		}
		view.setView("dynamic", dynamic);
		view.setView("createDate", PalUtils.formatDate(dynamic.getCreateDate()));
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
		map.put("message", "发布成功，等待审核");
		return map;
	}
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}
	
	//通过用户获取动态
	public Map<String, Object> getDynamicByUserID(Integer userID) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Dynamic> dynamics = dynamicDao.getDynamicByUserID(userID, 0);
		packData(dynamics, map);
		return map;
	}

	//h5添加动态
	public Map<String, Object> addDynamicH5(String content, String image) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		Dynamic dynamic = new Dynamic();
		if(image != null) {
			dynamic.setImage(image);
		} else {
			dynamic.setImage("");
		}
		dynamic.setUserID(threadUser.getId());
		dynamic.setSex(threadUser.getSex());
		dynamic.setStatus(1);
		dynamic.setContent(content);
		dynamicDao.addDynamic(dynamic);
		map.put("message", "发布成功，等待审核");
		return map;
	}

}
