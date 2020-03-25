package com.pal.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pal.service.MemberTicketService;
import com.pal.service.WalletService;
import com.pal.utils.PalUtils;
import com.pal.utils.PaypalConfig;

@Controller
public class PayController {
	
	@Autowired
	WalletService walletService;
	
	@Autowired
	MemberTicketService memberTicketService;
	
	@RequestMapping(path="/paysuccess/", method=RequestMethod.POST)
	@ResponseBody
	public String paysuccess(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		try {
			Map<String, Object> map = null;
			

            /**
             * 将 POST 信息分配给本地变量，可以根据您的需要添加
             */
            // 交易状态 Completed 代表交易成功
            String paymentStatus = request.getParameter("payment_status");
            System.out.println("交易状态" + paymentStatus);
            // 交易时间
            String paymentDate = request.getParameter("payment_date");
            // 交易id
            String txnId = request.getParameter("txn_id");
            // 父交易id
            String parentTxnId = request.getParameter("parent_txn_id");
            // 收款人email
            String receiverEmail = request.getParameter("receiver_email");
            // 收款人id
            String receiverId = request.getParameter("receiver_id");
            // 付款人email
            String payerEmail = request.getParameter("payer_email");
            // 付款人id
            String payerId = request.getParameter("payer_id");
            // 交易金额
            String mcGross = request.getParameter("mc_gross");
            // 自定义字段，我们存放的订单ID
            String custom = request.getParameter("custom");
            
            String[] customs = custom.split("&");
            //充值还是升级
            String payType = customs[0];
            //用户令牌
            String ticket = customs[2];
            //金钱
        	String money = customs[3];
        	
            if("1".equals(payType)) {
            	//为自己升级还是为别人升级
            	String upgradeType = customs[1];
            	if("1".equals(upgradeType)) {
            		System.out.println("为自己升级");
            		memberTicketService.addMemberTicketForUsername(ticket, money);
            	} else {
            		System.out.println("为别人升级");
            		String toUsername = customs[4];
            		memberTicketService.addMemberTicketForToUsername(ticket, toUsername, money);
            	}
            } else if("2".equals(payType)) {
            	//充值
            	String recharge = customs[1];
            	if("1".equals(recharge)) {
            		System.out.println("为自己充值");
            		map = walletService.rechargeByTicket(ticket, money);
            	} else {
            		System.out.println("为别人充值");
            		String toUsername = customs[4];
            		map = walletService.recharge(ticket, toUsername, money);
            	}
            }
            
            System.out.println("获取自定义字段" + custom);
            
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
