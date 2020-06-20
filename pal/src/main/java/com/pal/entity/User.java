package com.pal.entity;

import java.util.Date;

public class User {

	//用户ID
	private Integer id;
	
	//用户名
	private String username;
	
	//邮箱
	private String email;
	
	//密码
	private String password;
	
	//加密
	private String salt;
	
	//头像地址
	private String headLink;
	
	//性别 男-0	女-1
	private Integer sex;
	
	//创建时间
	private Date createDate;
	
	//在线状态	0-在线	1-隐身	2-离线
	private Integer onLineStatus;
	
	//登录时间更新
	private Date updateDate;
	
	//审核状态 正常-0	不正常-1
	//禁用状态 正常-0 禁用-1
	private Integer status;
	
	//头像状态 0 : 正常	1 : 审核中
	private Integer headStatus;
	
	//是否推送 0 : 推送	1 : 不推送
	private Integer pushStatus;
	
	//上线人员编号
	private String lineID;
	
	//注册地址
	private String address;
	
	//是否禁言 正常-0 禁用-1
	private Integer bannedStatus;
	
	//内部人员0-普通 1-内部
	private Integer type;

	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.salt = "";
		this.headLink = "";
		this.sex = 0;
		this.createDate = new Date();
		this.onLineStatus = 2;
		this.updateDate = null;
		this.status = 1;
		this.headStatus = 1;
		this.pushStatus = 1;
		this.lineID = "";
		this.address = "";
		this.type = 0;
		this.bannedStatus = 0;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadLink() {
		return headLink;
	}

	public void setHeadLink(String headLink) {
		this.headLink = headLink;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getHeadStatus() {
		return headStatus;
	}

	public void setHeadStatus(Integer headStatus) {
		this.headStatus = headStatus;
	}

	public Integer getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(Integer pushStatus) {
		this.pushStatus = pushStatus;
	}

	public String getLineID() {
		return lineID;
	}

	public void setLineID(String lineID) {
		this.lineID = lineID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getBannedStatus() {
		return bannedStatus;
	}

	public void setBannedStatus(Integer bannedStatus) {
		this.bannedStatus = bannedStatus;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getOnLineStatus() {
		return onLineStatus;
	}

	public void setOnLineStatus(Integer onLineStatus) {
		this.onLineStatus = onLineStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
