package com.pal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.EncryptedDao;
import com.pal.dao.UserDao;
import com.pal.entity.Encrypted;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.utils.PalUtils;

@Service
public class EncryptedService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	EncryptedDao encryptedDao;
	
	@Autowired
	UserDao userDao;

	//添加密保
	public Map<String, Object> updateEncrypted(String name, String email, String like) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		Encrypted encrypted = encryptedDao.selectByUsername(user.getUsername());
		if(encrypted == null) {
			encrypted = new Encrypted();
			encrypted.setEmail(email);
			encrypted.setName(name);
			encrypted.setLike(like);
			encryptedDao.addEncrypted(encrypted);
		} else {
			encryptedDao.updateEncrypted(user.getUsername(), name, email, like);
		}
		map.put("message", "更新成功");
		return map;
	}
	
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}

	//根据密保重置密码
	public Map<String, Object> reset(String username, String name, String email, String like) {
		Map<String, Object> map = new HashMap<String, Object>();
		Encrypted encrypted = encryptedDao.selectByUsername(username);
		if(encrypted == null) {
			map.put("username", "用户名无效");
			return map;
		}
		if(encrypted.getName().equals(name)) {
			map.put("name", "名字无效");
			return map;
		}
		if(encrypted.getEmail().equals(email)) {
			map.put("email", "邮箱无效");
			return map;
		}
		if(encrypted.getLike().equals(like)) {
			map.put("like", "喜欢的人无效");
			return map;
		}
		User user = userDao.selectUserByUsername(username);
		userDao.updatePassword(user.getId(), PalUtils.MD5("000000" + user.getSalt()));
		map.put("message", "重置成功");
		return map;
	}
	
}
