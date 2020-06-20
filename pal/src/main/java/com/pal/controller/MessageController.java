package com.pal.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pal.service.MessageService;
import com.pal.utils.PalUtils;

@Controller
public class MessageController {

	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	MessageService messageService;
	
	//获取联系人
	@RequestMapping(path="/user/getLinkman/", method=RequestMethod.GET)
	@ResponseBody
	public String getLinkman() {
		try {
			Map<String, Object> map = messageService.getLinkman();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取联系人失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	//获取消息
	@RequestMapping(path="/user/getMessageDetail/", method=RequestMethod.GET)
	@ResponseBody
	public String getMessageDetail(@RequestParam("userID") Integer userID) {
		try {
			Map<String, Object> map = messageService.getMessageDetail(userID);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取具体消息失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	@RequestMapping(path="/user/getTakeMessage/", method=RequestMethod.GET)
	@ResponseBody
	public String getTakeMessage(@RequestParam("userID") Integer userID) {
		try {
			Map<String, Object> map = messageService.getTakeMessage(userID);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取接受的消息失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	//添加消息
	@RequestMapping(path="/user/addMessage/", method=RequestMethod.POST)
	@ResponseBody
	public String addMessage(@RequestParam("toUserID") Integer toUserID, @RequestParam("content") String content) {
		try {
			Map<String, Object> map = messageService.addMessage(content, toUserID, null);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("添加消息失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	@RequestMapping(path="/user/addMessageH5/", method=RequestMethod.POST)
	@ResponseBody
	public String addMessageH5(@RequestParam("toUserID") Integer toUserID, @RequestParam("content") String content, @RequestParam("image") String image) {
		try {
			Map<String, Object> map = messageService.addMessageH5(content, toUserID, image);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("h5添加消息失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	
	@RequestMapping(path="/user/addMessageImage/", method=RequestMethod.POST)
	@ResponseBody
	public String addMessage(@RequestParam("toUserID") Integer toUserID, @RequestParam("content") String content, @RequestParam("image") MultipartFile image) {
		try {
			Map<String, Object> map = messageService.addMessage(content, toUserID, image);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("发送图片失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	//获取未读的消息量
	@RequestMapping(path="/user/getMessageNumByStatus/", method=RequestMethod.GET)
	@ResponseBody
	public String getMessageNumByStatus() {
		try {
			Map<String, Object> map = messageService.getMessageNumByStatus();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取消息量失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
