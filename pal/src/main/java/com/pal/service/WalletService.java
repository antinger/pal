package com.pal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.LoginTicketDao;
import com.pal.dao.WalletDao;
import com.pal.entity.HostHolder;
import com.pal.entity.LoginTicket;
import com.pal.entity.User;
import com.pal.entity.Wallet;

@Service
public class WalletService {

	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	WalletDao walletDao;
	
	@Autowired
	LoginTicketDao loginTicketDao;
	
	@Autowired
	OrderFormService orderFormService;
	
	//获取当前用户钱包
	public Map<String, Object> getUserWallet() {
		User user = getThreadUser();
		Wallet wallet = walletDao.selectByUsername(user.getUsername());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wallet", wallet);
		return map;
	}
	
	//为别人充值
	public Map<String, Object> recharge(String ticket, String username, String money) {
		Map<String, Object> map = new HashMap<String, Object>();
		walletDao.updateWallet(username, Integer.valueOf(money));
		orderFormService.addOrderForm(getThreadUserName(ticket), username, "充值", Integer.valueOf(money));
		map.put("message", "充值成功");
		return map;
	}
	
	//为自己充值
	public Map<String, Object> rechargeByTicket(String ticket, String money) {
		Map<String, Object> map = new HashMap<String, Object>();
		walletDao.updateWallet(getThreadUserName(ticket), Integer.valueOf(money));
		orderFormService.addOrderForm(getThreadUserName(ticket), getThreadUserName(ticket), "充值", Integer.valueOf(money));
		map.put("message", "充值成功");
		return map;
	}
	
	//获取当前线程用户
	private String getThreadUserName(String ticket) {
		LoginTicket loginTicket = loginTicketDao.selectByTicket(ticket);
		return loginTicket.getUsername();
	}
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}
	
}
