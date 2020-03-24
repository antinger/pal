package com.pal.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pal.utils.PalUtils;

@Controller
public class PayController {

	@RequestMapping(path="/paysuccess/", method=RequestMethod.GET)
	@ResponseBody
	public String paysuccess(HttpServletRequest request) {
		try {
			System.out.println(JSON.toJSONString(request));
			Map<String, Object> map = null;
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
	@RequestMapping(path="/payfail/", method=RequestMethod.GET)
	@ResponseBody
	public String payfail(HttpServletRequest request) {
		try {
			System.out.println(JSON.toJSONString(request));
			Map<String, Object> map = null;
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
