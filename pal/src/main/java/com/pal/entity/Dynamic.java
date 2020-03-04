package com.pal.entity;

import java.util.Date;

//动态
public class Dynamic {
	
	private Integer id;
	
	private Integer userID;
	
	private Integer sex;
	
	private String content;
	
	private String image;
	//审核状态1:未审核	0：审核通过
	private Integer status;
	
	//发布时间
	private Date createDate;
	
	public Dynamic() {
		this.id = 0;
		this.userID = 0;
		this.sex = 0;
		this.content = "";
		this.image = "";
		this.status = 0;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
