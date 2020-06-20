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

import com.pal.service.EncryptedService;
import com.pal.utils.PalUtils;

@Controller
public class EncryptedController {
	
	private static final Logger logger = LoggerFactory.getLogger(EncryptedController.class);
	
	@Autowired
	EncryptedService encryptedService;

	//更新，添加密保
	@RequestMapping(path="/user/updateEncrypted/", method=RequestMethod.POST)
	@ResponseBody
	public String updateEncrypted(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("like") String like) {
		try {
			Map<String, Object> map = encryptedService.updateEncrypted(name, email, like);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("添加密保失败" + e.getMessage());
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
	//通过密保更新密码
	@RequestMapping(path="/reset/", method=RequestMethod.POST)
	@ResponseBody
	public String reset(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("like") String like) {
		try {
			Map<String, Object> map = encryptedService.reset(username, name, email, like);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("更新密保失败" + e.getMessage());
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
}
