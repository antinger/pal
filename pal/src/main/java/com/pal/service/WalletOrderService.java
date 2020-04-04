package com.pal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.UserDao;
import com.pal.dao.WalletOrderDao;
import com.pal.entity.User;
import com.pal.entity.WalletOrder;
import com.pal.utils.PalUtils;

@Service
public class WalletOrderService {

	@Autowired
	WalletOrderDao walletOrderDao;
	
	@Autowired
	UserDao userDao;
	
	//添加钱包消费记录
	public void addWalletOrder(String username, String toUsername, String content, Integer price) {
		WalletOrder walletOrder = new WalletOrder();
		User user = userDao.selectUserByUsername(username);
		walletOrder.setCard(PalUtils.getRandomUUID());
		walletOrder.setUserName(username);
		walletOrder.setToUserName(toUsername);
		walletOrder.setContent(content);
		walletOrder.setPrice(price);
		if("".equals(user.getLineID()) || user.getLineID() == null) {
			walletOrder.setLineID("admin");
		} else {
			walletOrder.setLineID(user.getLineID());
		}
		walletOrderDao.addWalletOrder(walletOrder);
	}
	
}
