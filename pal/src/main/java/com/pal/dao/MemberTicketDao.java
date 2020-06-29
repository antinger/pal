package com.pal.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.MemberTicket;

@Mapper
public interface MemberTicketDao {
	
	String TABLE_NAME = "memberTicket";
    String INSERT_FIELDS = " username, createDate, expired, grade, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加会员
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{username},#{createDate},#{expired},#{grade},#{status})"})
    void addMemberTicket(MemberTicket memberTicket);
    
    //查找会员
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    MemberTicket selectByMemberTicket(String username);
    
    //更新会员
    @Update({"update ", TABLE_NAME, " set createDate=#{createDate},status=#{status},grade=#{grade},expired=#{expired} where username=#{username}"})
	void updateMemberTicket(MemberTicket memberTicket);
    
}
