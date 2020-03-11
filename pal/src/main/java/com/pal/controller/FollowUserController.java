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
public class FollowUserController {
	
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
	
	
}
