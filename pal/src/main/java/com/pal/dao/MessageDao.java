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
import com.pal.entity.Message;


@Mapper
public interface MessageDao {
	
	String TABLE_NAME = "message";
    String INSERT_FIELDS = " content, createDate, userID, toUserID, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加消息
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{content},#{createDate},#{userID},#{toUserID},#{status})"})
    void addMessage(Message message);
    
    //获取未读的消息量
    @Select({"select count(*) from ", TABLE_NAME, " where userID=#{userID} and status=#{status}"})
    int getNumByStatus(Integer userID, int status);
    
    @Select({"select count(*) from ", TABLE_NAME, " where userID=#{userID}"})
    int getNumByUserID(Integer userID);
    
    //获取发送的消息
    List<Message> getSendMessages(Integer userID);
    
    //获取接收的消息
    List<Message> getTakeMessages(Integer toUserID);
    
    //获取消息
	List<Message> getMessageByToUserID(int userID, Integer toUserID);
	
	@Update({"update ", TABLE_NAME, " set status=#{status} where id=#{id}"})
    void updateStatus(@Param("id") Integer id, @Param("status") Integer status);

	List<Message> getTakeMessage(int userID, Integer toUserID, int status);
    
}
