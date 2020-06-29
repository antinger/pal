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
	
	@Autowired
	WalletOrderService walletOrderService;
	
	@Autowired
	MemberTicketService memberTicketService;
	
	//获取当前用户钱包
	public Map<String, Object> getUserWallet() {
		User user = getThreadUser();
		Map<String, Object> map = new HashMap<String, Object>();
		Wallet wallet = walletDao.selectByUsername(user.getUsername());
		map.put("wallet", wallet);
		return map;
	}
	
	//为别人充值
	public Map<String, Object> recharge(String ticket, String username, String money, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		Wallet wallet = walletDao.selectByUsername(username);
		walletDao.updateWallet(wallet.getUsername(), wallet.getBalance() + Integer.valueOf(money));
		orderFormService.addOrderForm(getThreadUserName(ticket), username, "充值", Integer.valueOf(money), type);
		map.put("message", "充值成功");
		return map;
	}
	
	//为自己充值
	public Map<String, Object> rechargeByTicket(String ticket, String money, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		Wallet wallet = walletDao.selectByUsername(getThreadUserName(ticket));
		walletDao.updateWallet(wallet.getUsername(), wallet.getBalance() + Integer.valueOf(money));
		orderFormService.addOrderForm(getThreadUserName(ticket), getThreadUserName(ticket), "充值", Integer.valueOf(money), type);
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

	//用钱包升级
	public Map<String, Object> upgrade(Integer money, String toUsername, Integer upgradeType) {
		Map<String, Object> map = updateWallet(money);
		if(map.containsKey("flag")) {
			return map;
		}
		User threadUser = getThreadUser();
		//为自己升级
		if(upgradeType == 1) {
			walletOrderService.addWalletOrder(threadUser.getUsername(), threadUser.getUsername(), "升级", money);
			memberTicketService.addMemeberTicket(threadUser.getUsername(), String.valueOf(money));
		} else {
			//为别人升级
			walletOrderService.addWalletOrder(threadUser.getUsername(), toUsername, "升级", money);
			memberTicketService.addMemeberTicket(toUsername, String.valueOf(money));
		}
		return map;
	}
	
	//使用钱包买礼物
	public Map<String, Object> giftOrder(Integer money, String toUsername) {
		Map<String, Object> map = updateWallet(money);
		if(map.containsKey("flag")) {
			return map;
		}
		User threadUser = getThreadUser();
		walletOrderService.addWalletOrder(threadUser.getUsername(), toUsername, "送礼物", money);
		return map;
	}
	
	//判断金币是否充足-充足时更新余额
	private Map<String, Object> updateWallet(Integer money) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		Wallet wallet = walletDao.selectByUsername(threadUser.getUsername());
		if(wallet.getBalance() < money) {
			map.put("flag", true);
			return map;
		}
		Integer balance = wallet.getBalance() - money;
		walletDao.updateWallet(threadUser.getUsername(), balance);
		return map;
	}
	
}
