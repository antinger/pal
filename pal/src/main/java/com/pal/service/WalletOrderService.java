package com.pal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.WalletOrderDao;
import com.pal.entity.WalletOrder;
import com.pal.utils.PalUtils;

@Service
public class WalletOrderService {

	@Autowired
	WalletOrderDao walletOrderDao;
	
	//添加钱包消费记录
	public void addWalletOrder(String username, String toUsername, String content, Integer price) {
		WalletOrder walletOrder = new WalletOrder();
		walletOrder.setCard(PalUtils.getRandomUUID());
		walletOrder.setUserName(username);
		walletOrder.setToUserName(toUsername);
		walletOrder.setContent(content);
		walletOrder.setPrice(price);
		walletOrderDao.addWalletOrder(walletOrder);
	}
	
}
