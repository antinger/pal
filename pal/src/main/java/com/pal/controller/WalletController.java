package com.pal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pal.service.WalletService;
import com.pal.utils.PalUtils;

@Controller
public class WalletController {

	@Autowired
	WalletService walletService;
	
	@RequestMapping(path="/user/getUserWallet/", method=RequestMethod.GET)
	@ResponseBody
	public String getUserWallet() {
		try {
			Map<String, Object> map = walletService.getUserWallet();
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取钱包失败");
		}
	}
	
}
