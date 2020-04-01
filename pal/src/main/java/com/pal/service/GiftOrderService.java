package com.pal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.GiftDao;
import com.pal.dao.GiftOrderDao;
import com.pal.dao.UserDao;
import com.pal.entity.Gift;
import com.pal.entity.GiftOrder;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.entity.ViewObject;

@Service
public class GiftOrderService {

	@Autowired
	GiftOrderDao giftOrderDao;
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	GiftDao giftDao;
	
	@Autowired
	WalletService walletService;
	
	//获取发送的礼物
	public Map<String, Object> getSendGiftOrder() {
		Map<String,Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<GiftOrder> giftOrders = giftOrderDao.getSendGiftOrder(threadUser.getUsername());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (GiftOrder giftOrder : giftOrders) {
			ViewObject view = new ViewObject();
			view.setView("giftOrder", giftOrder);
			view.setView("createDate", giftOrder.getCreateDate());
			dealGift(giftOrder, view);
			dealUser(giftOrder.getToUsername(), view, "toUser");
		}
		map.put("data", data);
		return map;
	}
	
	//获取接受的礼物
	public Map<String, Object> getTakeGiftOrder() {
		Map<String,Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<GiftOrder> giftOrders = giftOrderDao.getTakeGiftOrder(threadUser.getUsername());
		System.out.println("获取接收的礼物" + giftOrders.size());
		List<ViewObject> data = new ArrayList<ViewObject>();
		for (GiftOrder giftOrder : giftOrders) {
			ViewObject view = new ViewObject();
			view.setView("giftOrder", giftOrder);
			view.setView("createDate", giftOrder.getCreateDate());
			dealGift(giftOrder, view);
			dealUser(giftOrder.getUsername(), view, "sendUser");
		}
		map.put("data", data);
		return map;
	}

	private User getThreadUser() {
		return hostHolder.getUser();
	}
	
	private void dealGift(GiftOrder giftOrder, ViewObject view) {
		Gift gift = giftDao.selectGiftById(giftOrder.getGiftID());
		gift.setPath(qiniuService.dealOnlyImage(gift.getPath()));
		view.setView("gift", gift);
	}
	
	private void dealUser(String username, ViewObject view, String key) {
		User user = userDao.selectUserByUsername(username);
		if(user.getHeadStatus() == 0) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
		view.setView(key, user);
	}

	//添加礼物
	public Map<String, Object> addGiftOrder(String toUsername, Integer giftID, Integer num, String content) {
		Map<String,Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		Gift gift = giftDao.selectGiftById(giftID);
		int price = num * gift.getPrice();
		//添加钱包消费记录
		map = walletService.giftOrder(price, toUsername);
		if(map.containsKey("flag")) {
			return map;
		}
		GiftOrder order = new GiftOrder();
		order.setToUsername(toUsername);
		order.setContent(content);
		order.setNum(num);
		order.setGiftID(giftID);
		order.setUsername(threadUser.getUsername());
		order.setPrice(price);
		giftOrderDao.addGiftOrder(order);
		return map;
	}

	//更新礼物记录状态
	public Map<String, Object> updateGiftOrderStatus(Integer id) {
		Map<String,Object> map = new HashMap<String, Object>();
		GiftOrder giftOrder = giftOrderDao.selectGiftOrderById(id);
		//添加钱包消费记录
		map = walletService.giftOrder(giftOrder.getPrice(), giftOrder.getToUsername());
		if(map.containsKey("flag")) {
			return map;
		}
		giftOrderDao.updateStatus(id, 1);
		map.put("message", "付款成功");
		return map;
	}
	
}
