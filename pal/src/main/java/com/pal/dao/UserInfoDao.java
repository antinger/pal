package com.pal.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.UserInfo;


@Mapper
public interface UserInfoDao {
	
	String TABLE_NAME = "userInfo";
    String INSERT_FIELDS = " username, birthday, education, height, weight, job, country, town ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{username},#{birthday},#{education},#{height},#{weight},#{job},#{country},#{town})"})
    int addUserInfo(UserInfo userInfo);
    
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    UserInfo selectByUsername(String username);
    
    @Update({"update ", TABLE_NAME, " set birthday=#{birthday},education=#{education},height=#{height},weight=#{weight},job=#{job},country=#{country},town=#{town} where username=#{username}"})
    void updateUserInfo(UserInfo userInfo);
	
}
