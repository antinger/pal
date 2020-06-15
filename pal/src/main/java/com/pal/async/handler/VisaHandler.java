package com.pal.async.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pal.async.EventHandler;
import com.pal.async.EventModel;
import com.pal.async.EventType;
import com.pal.service.MemberTicketService;
import com.pal.service.WalletService;

@Component
public class VisaHandler implements EventHandler {
	@Autowired
	WalletService walletService;
	
	@Autowired
	MemberTicketService memberTicketService;
	
	@Override
	public void handler(EventModel eventModel) {
		if(eventModel != null) {
			String custom = eventModel.getExts("custom");
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
            		memberTicketService.addMemberTicketForUsername(ticket, money, 2);
            	} else {
            		System.out.println("为别人升级");
            		String toUsername = customs[4];
            		memberTicketService.addMemberTicketForToUsername(ticket, toUsername, money, 2);
            	}
            } else if("2".equals(payType)) {
            	//充值
            	String recharge = customs[1];
            	if("1".equals(recharge)) {
            		System.out.println("为自己充值");
            		walletService.rechargeByTicket(ticket, money, 2);
            	} else {
            		System.out.println("为别人充值");
            		String toUsername = customs[4];
            		walletService.recharge(ticket, toUsername, money, 2);
            	}
            }
            
		}
	}

	@Override
	public List<EventType> getSupportEventType() {
		// TODO Auto-generated method stub
		return Arrays.asList(EventType.VISA);
	}
}
