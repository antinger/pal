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


@Mapper
public interface GiftOrderDao {
	
	String TABLE_NAME = "giftOrder";
    String INSERT_FIELDS = " giftID, num, price, username, toUsername, createDate, content, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加礼物
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{giftID},#{num},#{price},#{username},#{toUsername},#{createDate},#{content}, #{status})"})
    void addGiftOrder(GiftOrder giftOrder);
    
    //通过ID获取礼物记录
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    GiftOrder selectGiftOrderById(Integer id);
    
    //更新状态
    @Update({"update ", TABLE_NAME, " set status=#{status} where id=#{id}"})
    void updateStatus(@Param("id") Integer id, @Param("status") int status);

    //获取发送的礼物
    List<GiftOrder> getSendGiftOrder(String username);
    
    //获取接受的礼物
    List<GiftOrder> getTakeGiftOrder(String toUsername);
    
}
