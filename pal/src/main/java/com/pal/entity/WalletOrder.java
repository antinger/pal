package com.pal.entity;

import java.util.Date;

//金币消费记录
public class WalletOrder {

	private Integer id;
	
	private String card;
	
	private String userName;
	
	private String toUserName;
	//推广员
	private String lineID;
	//消费内容
	private String content;
	
	private Integer price;
	
	//提交时间
	private Date createDate;
	
	public WalletOrder() {
		this.id = 0;
		this.card = "";
		this.userName = "";
		this.toUserName = "";
		this.content = "";
		this.price = 0;
		this.createDate = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLineID() {
		return lineID;
	}

	public void setLineID(String lineID) {
		this.lineID = lineID;
	}
	
}
