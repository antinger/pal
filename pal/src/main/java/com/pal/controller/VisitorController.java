package com.pal.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.VisitorService;
import com.pal.utils.PalUtils;

@Controller
public class VisitorController {
	
	private static final Logger logger = LoggerFactory.getLogger(VisitorController.class);
	
	@Autowired
	VisitorService visitorService;
	
	//获取访问
	@RequestMapping(path="/user/getVisitor/", method=RequestMethod.GET)
	@ResponseBody
	public String getVistor() {
		try {
			Map<String, Object> map = visitorService.getVistor();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取游客失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取失败");
		}
	}
	
}
