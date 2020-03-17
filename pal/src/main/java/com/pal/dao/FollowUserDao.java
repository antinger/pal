package com.pal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.Dynamic;
import com.pal.entity.FollowUser;

@Mapper
public interface FollowUserDao {
	
	String TABLE_NAME = "followUser";
    String INSERT_FIELDS = " userID, followUserID ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //关注
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userID},#{followUserID})"})
    int addFollowUser(FollowUser followUser);
    
    //获取我的关注
	List<FollowUser> getFollowUser(Integer userID);
	
	//获取我的粉丝
	List<FollowUser> getFans(Integer followUserID);
	
	//获取是否存在当前记录
	@Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where userID=#{userID} and followUserID=#{followUserID}"})
	FollowUser getFollowUserByUserID(int userID, int followUserID);
	
}
