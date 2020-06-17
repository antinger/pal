package com.pal.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class VisaSuccessController {
	
	@RequestMapping(path="/visaSuccess/", method=RequestMethod.POST)
	@ResponseBody
	public String visaSuccess(@RequestParam("transType") String transType, 
			@RequestParam("orderNo") String orderNo, 
			@RequestParam("merNo") String merNo, 
			@RequestParam("terNo") String terNo, 
			@RequestParam("tradeNo") Integer tradeNo, 
			@RequestParam("amount") Integer amount, 
			@RequestParam("currencyCode") String currencyCode, 
			@RequestParam("respCode") String respCode, 
			@RequestParam("respMsg") String respMsg, 
			@RequestParam("merNotifyStatus") String merNotifyStatus, 
			@RequestParam("hashcode") String hashcode) {
		System.out.println("visa支付成功" + respMsg + "-" + respCode);
		return "";
	}
	
}
