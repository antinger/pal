package com.pal.entity;

import java.util.Date;

//游客记录
public class Visitor {

	private Integer id;
	//用户ID
	private Integer userID;
	//游客ID
	private Integer visitorID;
	
	//浏览时间
	private Date createDate;
	
	public Visitor() {
		this.id = 0;
		this.userID = 0;
		this.visitorID = 0;
		this.createDate = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public Integer getVisitorID() {
		return visitorID;
	}
	
	public void setVisitorID(Integer visitorID) {
		this.visitorID = visitorID;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
