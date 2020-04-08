package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.MessageService;
import com.pal.utils.PalUtils;

@Controller
public class MessageController {

	@Autowired
	MessageService messageService;
	
	//获取联系人
	@RequestMapping(path="/user/getLinkman/", method=RequestMethod.GET)
	@ResponseBody
	public String getLinkman() {
			Map<String, Object> map = messageService.getLinkman();
			return PalUtils.toJSONString(200, map);
	}
	
	//获取消息
	@RequestMapping(path="/user/getMessageDetail/", method=RequestMethod.GET)
	@ResponseBody
	public String getMessageDetail(@RequestParam("userID") Integer userID) {
		try {
			Map<String, Object> map = messageService.getMessageDetail(userID);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	//添加消息
	@RequestMapping(path="/user/addMessage/", method=RequestMethod.POST)
	@ResponseBody
	public String addMessage(@RequestParam("toUserID") Integer toUserID, @RequestParam("content") String content) {
		
			Map<String, Object> map = messageService.addMessage(content, toUserID);
			return PalUtils.toJSONString(200, map);
		
	}
	
	//获取未读的消息量
	@RequestMapping(path="/user/getMessageNumByStatus/", method=RequestMethod.GET)
	@ResponseBody
	public String getMessageNumByStatus() {
		try {
			Map<String, Object> map = messageService.getMessageNumByStatus();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
