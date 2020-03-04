package com.pal.entity;

import java.util.Date;

//用户信息
public class UserInfo {
	
	private Integer id;
	
	private String username;
	
	private Date birthday;
	
	//教育
	private String education;
	
	//身高
	private String height;
	
	//体重
	private String weight;
	
	//工作
	private String job;
	
	//国家
	private String country;
	
	//市区
	private String town;
	
	public UserInfo() {
		this.id = 0;
		this.username = "";
		this.birthday = null;
		this.education = "";
		this.height = "";
		this.weight = "";
		this.job = "";
		this.country = "";
		this.town = "";
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
}
