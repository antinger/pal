package com.pal.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.GiftService;
import com.pal.utils.PalUtils;

@Controller
public class GiftController {
	
	private static final Logger logger = LoggerFactory.getLogger(GiftController.class);
	
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
			logger.error("获取礼物失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
}
