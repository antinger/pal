package com.pal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.OrderFormDao;
import com.pal.dao.UserDao;
import com.pal.entity.OrderForm;
import com.pal.entity.User;
import com.pal.utils.PalUtils;

@Service
public class OrderFormService {
	
	@Autowired
	OrderFormDao orderFormDao;
	
	@Autowired
	UserDao userDao;

	public void addOrderForm(String username, String toUsername, String content, Integer price, Integer type) {
		OrderForm orderForm = new OrderForm();
		User user = userDao.selectUserByUsername(username);
		orderForm.setUserName(username);
		orderForm.setToUserName(toUsername);
		orderForm.setContent(content);
		orderForm.setPrice(price);
		orderForm.setType(type);
		if("".equals(user.getLineID()) || user.getLineID() == null) {
			orderForm.setLineID("admin");
		} else {
			orderForm.setLineID(user.getLineID());
		}
		orderForm.setCard(PalUtils.getRandomUUID());
		orderFormDao.addOrderForm(orderForm);
	}
	
}
