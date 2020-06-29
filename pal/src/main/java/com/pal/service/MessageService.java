package com.pal.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pal.dao.MessageDao;
import com.pal.dao.UserDao;
import com.pal.entity.HostHolder;
import com.pal.entity.MemberTicket;
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
	
	@Autowired
	MemberTicketService memberTicketService;

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
		Map<Integer, ViewObject> temp = new HashMap<Integer, ViewObject>();
		for (Message message : takeMessages) {
			ViewObject view = null;
			if(!temp.containsKey(message.getUserID())) {
				view = new ViewObject();
				dealMessage(message.getUserID(), view);
				view.setView("count", 0);
				temp.put(message.getUserID(), view);
			}
			if(message.getStatus() == 0) {
				view = temp.get(message.getUserID());
				int count = Integer.valueOf(view.getView().get("count").toString()) + 1;
				view.setView("count", count);
				temp.put(message.getUserID(), view);
			}
		}
		for (Message message : sendMessages) {
			if(!temp.containsKey(message.getToUserID())) {
				ViewObject view = new ViewObject();
				dealMessage(message.getToUserID(), view);
				temp.put(message.getToUserID(), view);
			}
		}
		for (Entry<Integer, ViewObject> entry : temp.entrySet()) {
			data.add(entry.getValue());
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
		dealData(messages, data, threadUser);
		map.put("data", data);
		return map;
	}
	
	private void dealData(List<Message> messages, List<ViewObject> data, User threadUser) {
		for (Message message : messages) {
			ViewObject view = new ViewObject();
			if(message.getUserID() == threadUser.getId()) {
				view.setView("flag", true);
				dealMessage(message.getUserID(), view);
			} else {
				view.setView("flag", false);
				dealMessage(message.getUserID(), view);
				if(message.getStatus() == 0) {
					messageDao.updateStatus(message.getId(), 1);
				}
			}
			if(!"".equals(message.getImage())) {
				message.setImage(qiniuService.dealOnlyImage(message.getImage()));
			}
			view.setView("message", message);
			view.setView("createDate", PalUtils.formatDate(message.getCreateDate()));
			data.add(view);
		}
	}
	
	public Map<String, Object> getTakeMessage(int userID) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		List<Message> takeMessages = messageDao.getTakeMessage(userID, threadUser.getId(), 0);
		Collections.sort(takeMessages, new DateSort());
		List<ViewObject> data = new ArrayList<>();
		dealData(takeMessages, data, threadUser);
		map.put("data", data);
		return map;
	}
	
	//处理消息
	private void dealMessage(Integer userID, ViewObject view) {
		User user = userDao.selectUserByID(userID);
		if(user.getHeadStatus() == 0) {
			user.setHeadLink(qiniuService.dealOnlyImage(user.getHeadLink()));
		}
		MemberTicket memberTicket = memberTicketService.getMemberTicket(user.getUsername());
		if(memberTicket != null) {
			view.setView("member", memberTicket.getGrade());
		}
		view.setView("user", user);
	}
	
	//添加消息
	public Map<String, Object> addMessage(String content, int toUserID, MultipartFile image) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		User toUser = userDao.selectUserByID(toUserID);
		if(!toUser.getUsername().equals("Service")) {
			if(threadUser.getBannedStatus() == 1) {
				map.put("eor", "禁言中");
				return map;
			}
			MemberTicket memberTicket = memberTicketService.getMemberTicket(threadUser.getUsername());
			int count = messageDao.getNumByUserID(threadUser.getId());
			if(count > 3) {
				if(memberTicket == null) {
					map.put("member", true);
					return map;
				}
			}
		}
		Message message = new Message();
		if(image != null) {
			Map<String, Object> saveImage = qiniuService.saveImage(image);
			String path = saveImage.get("fileList").toString();
			message.setImage(path);
		}
		message.setContent(content);
		message.setToUserID(toUserID);
		message.setUserID(threadUser.getId());
		messageDao.addMessage(message);
		ViewObject view = new ViewObject();
		if(!"".equals(message.getImage())) {
			message.setImage(qiniuService.dealOnlyImage(message.getImage()));
		}
		view.setView("message", message);
		view.setView("createDate", PalUtils.formatDate(message.getCreateDate()));
		view.setView("flag", true);
		dealMessage(message.getUserID(), view);
		map.put("message", view);
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
			} else {
				return 1;
			}
		}
	}

	public Map<String, Object> addMessageH5(String content, Integer toUserID, String image) {
		Map<String, Object> map = new HashMap<String, Object>();
		User threadUser = getThreadUser();
		User toUser = userDao.selectUserByID(toUserID);
		if(!toUser.getUsername().equals("Service")) {
			if(threadUser.getBannedStatus() == 1) {
				map.put("eor", "禁言中");
				return map;
			}
			MemberTicket memberTicket = memberTicketService.getMemberTicket(threadUser.getUsername());
			int count = messageDao.getNumByUserID(threadUser.getId());
			if(count > 3) {
				if(memberTicket == null) {
					map.put("member", true);
					return map;
				}
			}
		}
		Message message = new Message();
		message.setImage("");
		if(image != null && !"".equals(image)) {
			message.setImage(image);
		}
		message.setContent(content);
		message.setToUserID(toUserID);
		message.setUserID(threadUser.getId());
		messageDao.addMessage(message);
		ViewObject view = new ViewObject();
		if(!"".equals(message.getImage())) {
			message.setImage(qiniuService.dealOnlyImage(message.getImage()));
		}
		view.setView("message", message);
		view.setView("createDate", PalUtils.formatDate(message.getCreateDate()));
		view.setView("flag", true);
		dealMessage(message.getUserID(), view);
		map.put("message", view);
		return map;
	}
	
}
