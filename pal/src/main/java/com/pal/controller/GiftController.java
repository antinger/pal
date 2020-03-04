package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pal.service.GiftService;
import com.pal.utils.PalUtils;

@Controller
public class GiftController {
	
	@Autowired
	GiftService giftService;

	//获取最新的礼物
	@RequestMapping(path="/user/getLaterGift/", method=RequestMethod.GET)
	@ResponseBody
	public String getLaterGift() {
		try {
			Map<String, Object> map = giftService.getLaterGift();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
	//添加礼物
	@RequestMapping(path="/user/addGift/", method=RequestMethod.POST)
	@ResponseBody
	public String addGift(@RequestParam("name") String name, @RequestParam("price") Integer price, @RequestParam("path") MultipartFile path) {
		try {
			Map<String, Object> map = giftService.addGift(name, price, path);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "添加动态失败");
		}
	}
	
}
