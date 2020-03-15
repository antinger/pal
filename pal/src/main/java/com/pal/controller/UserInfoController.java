package com.pal.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.UserInfoService;
import com.pal.utils.PalUtils;

@Controller
public class UserInfoController {
	
	@Autowired
	UserInfoService userInfoService;
	
	//获取当前用户信息
	@RequestMapping(path="/user/getUserInfo/", method=RequestMethod.GET)
	@ResponseBody
	public String getUserInfo() {
		try {
			Map<String, Object> map = userInfoService.getUserInfo();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取当前用户信息失败");
		}
	}
	
	//获取他人用户信息
	@RequestMapping(path="/user/getUserInfoByUserName/", method=RequestMethod.GET)
	@ResponseBody
	public String getUserInfoByUserName(@RequestParam("username") String username) {
		try {
			Map<String, Object> map = userInfoService.getUserInfoByUserName(username);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取用户信息失败");
		}
	}
	
	//更新用户信息
	@RequestMapping(path="/user/updateUserInfo/", method=RequestMethod.POST)
	@ResponseBody
	public String updateUserInfo(@RequestParam("education") String education,@RequestParam("height") String height,@RequestParam("weight") String weight,@RequestParam("job") String job,@RequestParam("country") String country,@RequestParam("town") String town) {
		try {
			Map<String, Object> map = userInfoService.updateUserInfo(education, height, weight, job, country, town);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取用户信息失败");
		}
	}
	
}
