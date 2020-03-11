package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.FollowUserService;
import com.pal.utils.PalUtils;

@Controller
public class VisitorController {
	
	@Autowired
	FollowUserService followUserService;
	
	//添加关注
	@RequestMapping(path="/user/follow/", method=RequestMethod.POST)
	@ResponseBody
	public String follow(@RequestParam("followUserID") Integer followUserID) {
		try {
			Map<String, Object> map = followUserService.follow(followUserID);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
	//获取关注的人
	@RequestMapping(path="/user/getFollowUser/", method=RequestMethod.GET)
	@ResponseBody
	public String getFollowUser() {
		try {
			Map<String, Object> map = followUserService.getFollowUser();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取失败");
		}
	}
	
	//获取粉丝
	@RequestMapping(path="/user/getFans/", method=RequestMethod.GET)
	@ResponseBody
	public String getFans() {
		try {
			Map<String, Object> map = followUserService.getFans();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取失败");
		}
	}
	
	
}
