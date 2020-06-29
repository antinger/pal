package com.pal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.UserDao;
import com.pal.dao.UserInfoDao;
import com.pal.dao.WalletDao;
import com.pal.entity.HostHolder;
import com.pal.entity.MemberTicket;
import com.pal.entity.User;
import com.pal.entity.UserInfo;
import com.pal.entity.ViewObject;
import com.pal.entity.Wallet;
import com.pal.enums.HeadLinkStatusEnums;
import com.pal.utils.PalUtils;

@Service
public class UserInfoService {

	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	QiniuService qiniuService;
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Autowired
	WalletDao walletDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MemberTicketService memberTicketService;
	
	//获取用户信息
	public Map<String, Object> getUserInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = hostHolder.getUser();
		dealUser(user, map);
		return map;
	}
	
	//根据用户名获取信息
	public Map<String, Object> getUserInfoByID(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userDao.selectUserByID(id);
		dealUser(user, map);
		return map;
	}
	
	//包装用户信息
	private void dealUser(User user, Map<String, Object> map) {
		dealWallet(user.getUsername(), map);
		dealMember(map, user.getUsername());
		dealUserInfo(user, map);
	}
	
	//处理用户信息
	private void dealUserInfo(User user, Map<String, Object> map) {
		if(!"".equals(user.getHeadLink()) && user.getHeadStatus() == HeadLinkStatusEnums.PASS.getHeadLinkStatus()) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
		map.put("user", user);
		UserInfo userInfo = userInfoDao.selectByUsername(user.getUsername());
		ViewObject view = new ViewObject();
		view.setView("info", userInfo);
		view.setView("birthday", PalUtils.formatBirth(userInfo.getBirthday()));
		map.put("userInfo", view);
	}
	
	//处理用户钱包
	private void dealWallet(String username, Map<String, Object> map) {
		Wallet wallet = walletDao.selectByUsername(username);
		map.put("wallet", wallet);
	}
	
	//处理用户会员
	private void dealMember(Map<String, Object> map, String username) {
		MemberTicket memberTicket = memberTicketService.getMemberTicket(username);
		if(memberTicket != null) {
			map.put("member", memberTicket.getGrade());
		}
	}
	
	//更新用户信息
	public Map<String, Object> updateUserInfo(String education,String height,String weight,String job,String country,String town) {
		Map<String, Object> map = new HashMap<String, Object>();
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(hostHolder.getUser().getUsername());
		userInfo.setEducation(education);
		userInfo.setHeight(height);
		userInfo.setWeight(weight);
		userInfo.setJob(job);
		userInfo.setCountry(country);
		userInfo.setTown(town);
		userInfoDao.updateUserInfo(userInfo);
		map.put("message", "更新成功");
		return map;
	}

}
