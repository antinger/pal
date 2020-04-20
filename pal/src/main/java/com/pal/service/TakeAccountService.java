package com.pal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.TakeAccountDao;
import com.pal.entity.TakeAccount;

@Service
public class TakeAccountService {

	@Autowired
	TakeAccountDao takeAccountDao;
	
	public Map<String, Object> getAccount(){
		Map<String, Object> map = new HashMap<String, Object>();
		TakeAccount account = takeAccountDao.selectAdminByID(1);
		map.put("account", account.getCard());
		return map;
	}
	
}
