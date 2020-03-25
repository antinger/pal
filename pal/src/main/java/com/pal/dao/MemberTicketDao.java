package com.pal.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.Gift;
import com.pal.entity.GiftOrder;
import com.pal.entity.LoginTicket;
import com.pal.entity.MemberTicket;
import com.pal.entity.Message;


@Mapper
public interface MemberTicketDao {
	
	String TABLE_NAME = "memberTicket";
    String INSERT_FIELDS = " username, createDate, expired, grade, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加会员
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{username},#{createDate},#{expired},#{grade},#{status})"})
    void addMemberTicket(MemberTicket memberTicket);
    
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    MemberTicket selectByMemberTicket(String username);
    
    //获取未读的消息量
    @Select({"select count(*) from ", TABLE_NAME, " where uerrID=#{userID} and status=#{status}"})
    int getNumByStatus(Integer userID, int status);
    
    //获取发送的消息
    List<Message> getSendMessages(Integer userID);
    
    //获取接收的消息
    List<Message> getTakeMessages(Integer toUserID);
    
    //获取消息
	List<Message> getMessageByToUserID(int userID, Integer toUserID);
    
}
