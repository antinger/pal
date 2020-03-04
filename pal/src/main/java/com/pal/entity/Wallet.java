package com.pal.entity;

public class Wallet {

	private Integer id;
	
	//用户名
	private String username;
	
	//余额
	private Integer balance;
	
	public Wallet() {
		this.id = 0;
		this.username = "";
		this.balance = 0;
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
}
