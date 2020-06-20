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

import com.pal.service.WalletService;
import com.pal.utils.PalUtils;

@Controller
public class WalletController {

	private static final Logger logger = LoggerFactory.getLogger(WalletController.class);
	
	@Autowired
	WalletService walletService;
	
	//获取用户钱包
	@RequestMapping(path="/user/getUserWallet/", method=RequestMethod.GET)
	@ResponseBody
	public String getUserWallet() {
		try {
			Map<String, Object> map = walletService.getUserWallet();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("获取钱包失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取钱包失败");
		}
	}
	
	//花费余额
	@RequestMapping(path="/user/updateUserWallet/", method=RequestMethod.POST)
	@ResponseBody
	public String updateUserWallet(@RequestParam("money") Integer money, @RequestParam("upgradeType") Integer upgradeType, @RequestParam("toUsername") String toUsername) {
		try {
			Map<String, Object> map = walletService.upgrade(money, toUsername, upgradeType);
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("花费余额失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取钱包失败");
		}
	}
	
}
