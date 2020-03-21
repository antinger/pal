package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.GiftOrderService;
import com.pal.utils.PalUtils;

@Controller
public class GiftOrderController {

	@Autowired
	GiftOrderService giftOrderService;
	
	//获取发送的礼物
	@RequestMapping(path="/user/getSendGiftOrder/", method=RequestMethod.GET)
	@ResponseBody
	public String getSendGiftOrder() {
		try {
			Map<String, Object> map = giftOrderService.getSendGiftOrder();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
	//获取接受的礼物
	@RequestMapping(path="/user/getTakeGiftOrder/", method=RequestMethod.GET)
	@ResponseBody
	public String getTakeGiftOrder() {
		try {
			Map<String, Object> map = giftOrderService.getTakeGiftOrder();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
	//添加礼物记录
	@RequestMapping(path="/user/addGiftOrder/", method=RequestMethod.POST)
	@ResponseBody
	public String addGiftOrder(@RequestParam("toUsername") String toUsername, @RequestParam("giftID") Integer giftID, @RequestParam("content") String content) {
		try {
			Map<String, Object> map = giftOrderService.addGiftOrder(toUsername, giftID, content);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
	//更新礼物记录状态
	@RequestMapping(path="/user/updateGiftOrderStatus/", method=RequestMethod.POST)
	@ResponseBody
	public String updateGiftOrderStatus(@RequestParam("id") Integer id) {
		try {
			Map<String, Object> map = giftOrderService.updateGiftOrderStatus(id);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取动态失败");
		}
	}
	
}
