package com.pal.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.LoginTicketDao;
import com.pal.dao.MemberTicketDao;
import com.pal.entity.HostHolder;
import com.pal.entity.LoginTicket;
import com.pal.entity.MemberTicket;
import com.pal.entity.User;
import com.pal.utils.PalUtils;

@Service
public class MemberTicketService {

	@Autowired
	MemberTicketDao memberTicketDao;
	
	@Autowired
	LoginTicketDao loginTicketDao;
	
	@Autowired
	OrderFormService orderFormService;
	
	@Autowired
	HostHolder hostHolder;
	
	//为自己升级会员
	public Map<String, Object> addMemberTicketForUsername(String ticket, String money, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		//获取当前线程用户名
		String username = getThreadUserName(ticket);
		//添加会员
		System.out.println("添加会员");
		addMemeberTicket(username, money);
		orderFormService.addOrderForm(username, username, "升级", Integer.valueOf(money), type);
		map.put("message", "充值成功");
		return null;
	}
	
	//为别人升级会员
	public Map<String, Object> addMemberTicketForToUsername(String ticket, String toUsername, String money, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		//添加会员
		addMemeberTicket(toUsername, money);
		//当前用户
		String username = getThreadUserName(ticket);
		orderFormService.addOrderForm(username, toUsername, "升级", Integer.valueOf(money), type);
		map.put("message", "充值成功");
		return map;
	}
	
	//升级会员
	public void addMemeberTicket(String username, String money) {
		//获取会员
		MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(username);
		//级别
		String message = PalUtils.getGrade(money);
		String[] messages = message.split("&");
		Integer grade = Integer.valueOf(messages[0]);
		Integer mouths = Integer.valueOf(messages[1]);
		long expired = 1000L * 60 * 60 * 24 * 30 * mouths;;
		boolean flag = true;
		if(memberTicket == null) {
			flag = false;
			memberTicket = new MemberTicket();
			memberTicket.setCreateDate(new Date());
			expired = new Date().getTime() + expired;
		} else {
			long currentExpired = memberTicket.getExpired().getTime();
			long currentTime = new Date().getTime();
			//判断是否过期，如果过期
			if(currentExpired < currentTime) {
				memberTicket.setCreateDate(new Date());
				expired = new Date().getTime() + expired;
			} else {
				expired = currentExpired + expired;
			}
		}
		memberTicket.setGrade(grade);
		memberTicket.setUsername(username);
		memberTicket.setExpired(new Date(expired));
		memberTicket.setStatus(0);
		if(flag) {
			memberTicketDao.updateMemberTicket(memberTicket);
		} else {
			memberTicketDao.addMemberTicket(memberTicket);
		}
	}
	
	//获取当前线程用户
	private String getThreadUserName(String ticket) {
		LoginTicket loginTicket = loginTicketDao.selectByTicket(ticket);
		return loginTicket.getUsername();
	}
	
	private User getThreadUser() {
		return hostHolder.getUser();
	}
	
	//判断当前用户是否是会员
	public boolean isMemberTicket() {
		boolean flag = true;
		MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(getThreadUser().getUsername());
		if(memberTicket == null) {
			flag = false;
		}
		if(memberTicket.getStatus() == 1) {
			flag = false;
		}
		if(memberTicket.getExpired().getTime() < new Date().getTime()) {
			memberTicket.setStatus(1);
			memberTicketDao.updateMemberTicket(memberTicket);
			flag = false;
		}
		return flag;
	}
	
	//根据用户名获取会员
	public MemberTicket getMemberTicket(String username) {
		MemberTicket memberTicket = memberTicketDao.selectByMemberTicket(username);
		if(memberTicket == null) {
			return null;
		}
		if(memberTicket.getStatus() == 1) {
			return null;
		}
		if(memberTicket.getExpired().getTime() < new Date().getTime()) {
			memberTicket.setStatus(1);
			memberTicketDao.updateMemberTicket(memberTicket);
			return null;
		}
		return memberTicket;
	}
}
