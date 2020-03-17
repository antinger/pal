package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.VisitorService;
import com.pal.utils.PalUtils;

@Controller
public class VisitorController {
	
	@Autowired
	VisitorService visitorService;
	
	//添加游客
	@RequestMapping(path="/user/addVisitor/", method=RequestMethod.POST)
	@ResponseBody
	public String addVisitor(@RequestParam("visitorID") Integer visitorID) {
		try {
			Map<String, Object> map = visitorService.addVisitor(visitorID);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "访问失败");
		}
	}
	
	//获取访问
	@RequestMapping(path="/user/getVisitor/", method=RequestMethod.GET)
	@ResponseBody
	public String getVistor() {
		try {
			Map<String, Object> map = visitorService.getVistor();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取失败");
		}
	}
	
}
