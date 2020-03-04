package com.pal.entity;

import java.util.Date;

//登录令牌
public class LoginTicket {
	
    private int id;
    //用户识别信息
    private String username;
	//有效时间
    private Date expired;
	// 0有效，1无效
    private int status;
	//令牌信息
    private String ticket;
    
    public LoginTicket() {
		this.id = 0;
		this.setUsername("");
		this.expired = null;
		this.status = 0;
		this.ticket = "";
	}
    
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}
