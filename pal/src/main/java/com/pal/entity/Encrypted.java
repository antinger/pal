package com.pal.entity;

//密保
public class Encrypted {

	private Integer id;
	//用户名字
	private String username;
	//名字
	private String name;
	//邮箱地址
	private String email;
	//喜欢的人
	private String like;
	
	public Encrypted() {
		this.id = 0;
		this.username = "";
		this.name = "";
		this.email = "";
		this.like = "";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}
	
}
