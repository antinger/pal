package com.pal.entity;

import java.util.Date;

//会员令牌
public class MemberTicket {
	
	private Integer id;
	
	//绑定的用户名
	private String username;
	
	//开始时间
	private Date createDate;
	
	//有效期
	private Date expired;
	
	//会员状态
	private Integer status;
	
	//等级 0 : 钻石	1 : 皇冠
	private Integer grade;
	
	public MemberTicket() {
		this.id = 0;
		this.username = "";
		this.createDate = new Date();
		this.expired = null;
		this.status = 1;
		this.grade = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getExpired() {
		return expired;
	}

	public void setExpired(Date expired) {
		this.expired = expired;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
}
