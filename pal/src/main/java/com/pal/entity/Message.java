package com.pal.entity;

import java.util.Date;

public class Message {

	private Integer id;
	
	private String content;
	
	private String image;
	
	private Date createDate;
	
	private Integer userID;
	
	private Integer toUserID;
	//状态
	private Integer status;
	
	public Message() {
		this.id = 0;
		this.content = "";
		this.image = "";
		this.createDate = new Date();
		this.userID = 0;
		this.toUserID = 0;
		this.status = 0;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public Integer getToUserID() {
		return toUserID;
	}
	
	public void setToUserID(Integer toUserID) {
		this.toUserID = toUserID;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
