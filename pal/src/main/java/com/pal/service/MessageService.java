package com.pal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pal.dao.MessageDao;
import com.pal.dao.UserDao;
import com.pal.entity.HostHolder;
import com.pal.entity.Message;
import com.pal.entity.User;
import com.pal.entity.ViewObject;
import com.pal.utils.PalUtils;

@Service
public class MessageService {
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	QiniuService qiniuService;

	//获取未读的消息
	public Map<String, Object> getMessageNumByStatus() {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = getThreadUser();
		int count = messageDao.getNumByStatus(user.getId(), 0);
		map.put("count", count);
		return map;
	}
	
	//获取联系人
	public Map<String, Object> getLinkman() {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<Message> takeMessages = messageDao.getTakeMessages(threadUser.getId());
		List<Message> sendMessages = messageDao.getSendMessages(threadUser.getId());
		List<ViewObject> data = new ArrayList<>();
		Set<Integer> counter = new HashSet<>();
		for (Message message : takeMessages) {
			ViewObject view = null;
			if(!counter.contains(message.getUserID())) {
				view = new ViewObject();
				dealMessage(message.getUserID(), view);
				view.setView("count", 0);
				counter.add(message.getUserID());
			}
			if(message.getStatus() == 0) {
				int count = Integer.valueOf(view.getView().get("count").toString()) + 1;
				view.setView("count", count);
			}
			data.add(view);
		}
		for (Message message : sendMessages) {
			if(!counter.contains(message.getToUserID())) {
				ViewObject view = new ViewObject();
				dealMessage(message.getToUserID(), view);
				counter.add(message.getToUserID());
				data.add(view);
			}
		}
		map.put("data", data);
		return map;
	}
	
	//根据发送人获取消息
	public Map<String, Object> getMessageDetail(int userID) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<Message> takeMessages = messageDao.getMessageByToUserID(userID, threadUser.getId());
		List<Message> sendMessages = messageDao.getMessageByToUserID(threadUser.getId(), userID);
		List<Message> messages = new ArrayList<>();
		messages.addAll(sendMessages);
		messages.addAll(takeMessages);
		Collections.sort(messages, new DateSort());
		
		List<ViewObject> data = new ArrayList<>();
		for (Message message : messages) {
			ViewObject view = new ViewObject();
			if(message.getUserID() == threadUser.getId()) {
				view.setView("flag", true);
				dealMessage(message.getToUserID(), view);
			} else {
				view.setView("flag", false);
				dealMessage(message.getUserID(), view);
			}
			view.setView("message", message);
			view.setView("createDate", PalUtils.formatDate(message.getCreateDate()));
			data.add(view);
		}
		map.put("data", data);
		return map;
	}
	
	//处理消息
	private void dealMessage(Integer userID, ViewObject view) {
		User user = userDao.selectUserByID(userID);
		if(user.getHeadStatus() == 1) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
		view.setView("user", user);
	}
	
	//添加消息
	public Map<String, Object> addMessage(String content, int toUserID) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		Message message = new Message();
		message.setContent(content);
		message.setToUserID(toUserID);
		message.setUserID(threadUser.getId());
		messageDao.addMessage(message);
		map.put("message", "添加成功");
		return map;
	}
	
	//获取当前线程用户
	private User getThreadUser() {
		return hostHolder.getUser();
	}

	//从小到大排序
	private class DateSort implements Comparator<Message> {
		@Override
		public int compare(Message o1, Message o2) {
			if(o1.getCreateDate().getTime() < o2.getCreateDate().getTime()) {
				return -1;
			}
			return 0;
		}
	}
	
}
