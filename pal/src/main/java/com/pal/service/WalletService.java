package com.pal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.WalletDao;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.Wallet;

@Service
public class WalletService {

	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	WalletDao walletDao;
	
	//获取当前用户钱包
	public Map<String, Object> getUserWallet() {
		User user = getThreadUser();
		Wallet wallet = walletDao.selectByUsername(user.getUsername());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("wallet", wallet);
		return map;
	}
	
	//获取当前线程用户
	private User getThreadUser() {
		return hostHolder.getUser();
	}
	
}
