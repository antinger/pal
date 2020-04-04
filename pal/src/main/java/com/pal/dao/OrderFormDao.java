package com.pal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.pal.entity.Message;
import com.pal.entity.OrderForm;


@Mapper
public interface OrderFormDao {
	
	String TABLE_NAME = "orderForm";
    String INSERT_FIELDS = " card, userName, toUserName, lineID, content, price, createDate, doneDate ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加记录
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{card},#{userName},#{toUserName},#{lineID},#{content},#{price},#{createDate},#{doneDate})"})
    void addOrderForm(OrderForm orderForm);
    
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
