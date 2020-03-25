package com.pal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.OrderFormDao;
import com.pal.entity.OrderForm;
import com.pal.utils.PalUtils;

@Service
public class OrderFormService {
	
	@Autowired
	OrderFormDao orderFormDao;

	public void addOrderForm(String username, String toUsername, String content, Integer price) {
		OrderForm orderForm = new OrderForm();
		orderForm.setUserName(username);
		orderForm.setToUserName(toUsername);
		orderForm.setContent(content);
		orderForm.setPrice(price);
		orderFormDao.addOrderForm(orderForm);
		orderForm.setCard(PalUtils.getRandomUUID());
	}
	
}
