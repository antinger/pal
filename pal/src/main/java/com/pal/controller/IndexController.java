package com.pal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
    public String index(HttpServletRequest request) {
		String userAgent = request.getHeader("user-agent");
		// 判断属于哪类设备 pc
		if (userAgent.contains("Windows") || userAgent.contains("Intel Mac")){
			return "redirect:/pages/index.html";
		}
		// 手机
		if (userAgent.contains("iPhone") || userAgent.contains("Android") || userAgent.contains("iPad")){
			return "redirect:/h5/index.html";
		}
        return "";
    }
	
}
