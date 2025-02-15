package com.pal.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.UserService;
import com.pal.utils.AddressUtils;
import com.pal.utils.PalUtils;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path="/register/", method=RequestMethod.POST)
	@ResponseBody
	public String register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("birthday") String birthday, @RequestParam("sex") Integer sex, HttpServletResponse response, HttpServletRequest request) {
		try {
			String ip = PalUtils.getIpAddress(request);
			ip = ip + "-" + AddressUtils.getAddressByIP(ip);
			Date date = PalUtils.parseDate(birthday);
			Map<String, Object> map = userService.register(username, password, email, date, sex, ip);
			if(map.containsKey("ticket")) {
				Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
				cookie.setMaxAge(60 * 60 * 24 * 30);
				cookie.setPath("/");
				response.addCookie(cookie);
				return PalUtils.toJSONString(200, map);
			} else {
				return PalUtils.toJSONString(500, map);
			}
		} catch (Exception e) {
			logger.error("注册失败" + e.getMessage());
			return PalUtils.toJSONString(500, "注册失败");
		}
	}
	
	@RequestMapping(path="/login/", method=RequestMethod.POST)
	@ResponseBody
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response) {
		try {
			Map<String, Object> map = userService.login(username, password);
			if(map.containsKey("ticket")) {
				Cookie cookie = new Cookie("ticket", map.get("ticket").toString());
				cookie.setMaxAge(60 * 60 * 24 * 30);
				cookie.setPath("/");
				response.addCookie(cookie);
				return PalUtils.toJSONString(200, map);
			} else {
				return PalUtils.toJSONString(500, map);
			}
		} catch (Exception e) {
			logger.error("登录失败" + e.getMessage());
			return PalUtils.toJSONString(500, "登录失败");
		}
	}
	
	@RequestMapping(path="/user/logout/", method=RequestMethod.GET)
	@ResponseBody
	public String logout() {
		try {
			Map<String, Object> map = userService.logout();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("退出失败" + e.getMessage());
			return PalUtils.toJSONString(500, "退出失败");
		}
	}
	
}
