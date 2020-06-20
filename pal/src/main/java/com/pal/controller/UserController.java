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

import com.pal.service.UserService;
import com.pal.utils.PalUtils;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	//获取推送的用户
	@RequestMapping(path="/user/getPushUser/", method=RequestMethod.GET)
	@ResponseBody
	public String getPushUser() {
		try {
			Map<String, Object> map = userService.getPushUser();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取推送用户失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	//根据用户名获取用户
	@RequestMapping(path="/user/getUserByUsername/", method=RequestMethod.GET)
	@ResponseBody
	public String getUserByUsername(@RequestParam("username") String username) {
		try {
			Map<String, Object> map = userService.getUserByUsername(username);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("根据用户名获取用户失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	@RequestMapping(path="/user/updateOnLineStatus/", method=RequestMethod.GET)
	@ResponseBody
	public String updateOnLineStatus(@RequestParam("onLineStatus") Integer onLineStatus) {
		try {
			Map<String, Object> map = userService.updateOnLineStatus(onLineStatus);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("更新用户在线状态失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	//获取首页推荐用户
	@RequestMapping(path="/user/getLaterUser/", method=RequestMethod.GET)
	@ResponseBody
	public String getLaterUser(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		try {
			Map<String, Object> map = userService.getLaterUser(page, limit);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取首页推荐用户失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取最新用户失败");
		}
	}
	
	//更新用户密码
	@RequestMapping(path="/user/updatePassword/", method=RequestMethod.POST)
	@ResponseBody
	public String updatePassword(@RequestParam("password") String password, @RequestParam("oldPassword") String oldPassword) {
		try {
			Map<String, Object> map = userService.updatePassword(password, oldPassword);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("更新用户密码" + e.getMessage());
			return PalUtils.toJSONString(500, "获取最新用户失败");
		}
	}
	
	//更新头像
	@RequestMapping(path="/user/updateHeadLink/", method=RequestMethod.POST)
	@ResponseBody
	public String updateHeadLink(@RequestParam("image") MultipartFile image) {
		try {
			Map<String, Object> map = userService.updateHeadLink(image);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("更新用户头像" + e.getMessage());
			return PalUtils.toJSONString(500, "更新头像失败");
		}
	}
	
	@RequestMapping(path="/user/updateHeadLinkH5/", method=RequestMethod.POST)
	@ResponseBody
	public String updateHeadLinkH5(@RequestParam("image") String image) {
		try {
			Map<String, Object> map = userService.updateHeadLinkH5(image);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("更新h5头像失败" + e.getMessage());
			return PalUtils.toJSONString(500, "更新头像失败");
		}
	}
}
