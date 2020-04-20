package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.TakeAccountService;
import com.pal.utils.PalUtils;

@Controller
public class TakeAccountController {
	
	@Autowired
	TakeAccountService takeAccountService;

	
	@RequestMapping(path="/user/getAccount/", method=RequestMethod.GET)
	@ResponseBody
	public String getAccount() {
		try {
			Map<String, Object> map = takeAccountService.getAccount();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
