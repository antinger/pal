package com.pal.async;

import java.util.HashMap;
import java.util.Map;

public class EventModel {

	private EventType eventType;
	
	//事件产生的实体类型
	private Integer entityType;
	
	//事件产生的实体ID
	private Integer entityID;
	
	//事件产生者
	private Integer userID;
	
	//事件消费者
	private Integer toUserID;
	
	private Map<String, String> exts = new HashMap<String, String>();

	public EventType getEventType() {
		return eventType;
	}

	public EventModel setEventType(EventType eventType) {
		this.eventType = eventType;
		return this;
	}

	public Integer getEntityType() {
		return entityType;
	}

	public EventModel setEntityType(Integer entityType) {
		this.entityType = entityType;
		return this;
	}

	public Integer getEntityID() {
		return entityID;
	}

	public EventModel setEntityID(Integer entityID) {
		this.entityID = entityID;
		return this;
	}

	public Integer getUserID() {
		return userID;
	}

	public EventModel setUserID(Integer userID) {
		this.userID = userID;
		return this;
	}

	public Integer getToUserID() {
		return toUserID;
	}

	public EventModel setToUserID(Integer toUserID) {
		this.toUserID = toUserID;
		return this;
	}

	public Map<String, String> getExts() {
		return exts;
	}

	public void setExts(Map<String, String> exts) {
		this.exts = exts;
	}
	
	public EventModel setExts(String key, String value) {
		this.exts.put(key, value);
		return this;
	}
	
	public String getExts(String key) {
		return this.exts.get(key);
	}
	
}
