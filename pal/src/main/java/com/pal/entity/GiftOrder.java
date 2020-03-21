package com.pal.entity;

import java.util.Date;

//礼物记录
public class GiftOrder {

	private Integer id;
	//礼物ID
	private Integer giftID;
	//发送者
	private String username;
	//接受者
	private String toUsername;
	
	private Date createDate;
	
	private String content;
	
	//0：生成记录-待付款
	//1:记录完成-付款完成
	private Integer status;
	
	public GiftOrder() {
		this.id = 0;
		this.giftID = 0;
		this.username = "";
		this.toUsername = "";
		this.createDate = new Date();
		this.content = "";
		this.setStatus(0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGiftID() {
		return giftID;
	}

	public void setGiftID(Integer giftID) {
		this.giftID = giftID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToUsername() {
		return toUsername;
	}

	public void setToUsername(String toUsername) {
		this.toUsername = toUsername;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
