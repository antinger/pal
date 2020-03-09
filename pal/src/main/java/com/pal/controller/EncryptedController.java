package com.pal.controller;

import java.util.Map;

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
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
	//通过密保充值密码
	@RequestMapping(path="/reset/", method=RequestMethod.POST)
	@ResponseBody
	public String reset(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("like") String like) {
		try {
			Map<String, Object> map = encryptedService.reset(username, name, email, like);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
}
