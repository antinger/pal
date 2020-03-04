package com.pal.entity;

//粉丝
public class FollowUser {

	private Integer id;
	
	//用户
	private Integer userID;
	
	//关注的人的id
	private Integer followUserID;
	
	public FollowUser() {
		this.id = 0;
		this.userID = 0;
		this.followUserID = 0;
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

	public Integer getFollowUserID() {
		return followUserID;
	}

	public void setFollowUserID(Integer followUserID) {
		this.followUserID = followUserID;
	}
	
}
