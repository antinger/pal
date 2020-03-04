package com.pal.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.LoginTicket;


@Mapper
public interface LoginTicketDao {
	
	String TABLE_NAME = "loginTicket";
    String INSERT_FIELDS = " username, expired, status, ticket ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{username},#{expired},#{status},#{ticket})"})
    int addTicket(LoginTicket ticket);
    
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where ticket=#{ticket}"})
    LoginTicket selectByTicket(String ticket);
    
    @Update({"update ", TABLE_NAME, " set status=#{status} where username=#{username}"})
    void updateStatus(@Param("username") String username, @Param("status") int status);
	
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    LoginTicket selectByUsername(String username);

    @Update({"update ", TABLE_NAME, " set expired=#{expired} where username=#{username}"})
	void updateExpired(String username, Date expired);
}
