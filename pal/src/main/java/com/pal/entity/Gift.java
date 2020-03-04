package com.pal.entity;

import java.util.Date;

//礼物

public class Gift {

	private Integer id;
	
	private String name;
	
	private String path;
	
	private Integer price;
	
	//状态
	private Integer status;
	
	//创建时间
	private Date createDate;
	
	public Gift() {
		this.id = 0;
		this.name = "";
		this.path = "";
		this.price = 0;
		this.status = 0;
		this.createDate = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
