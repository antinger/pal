package com.pal.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.Gift;


@Mapper
public interface GiftDao {
	
	String TABLE_NAME = "gift";
    String INSERT_FIELDS = " name, path, price, status, createDate ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加礼物
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{name},#{path},#{price},#{status},#{createDate})"})
    void addGift(Gift gift);
    
    //通过ID获取礼物
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    Gift selectGiftById(Integer id);
    
    //更新礼物
    @Update({"update ", TABLE_NAME, " set status=#{status}, createDate=#{createDate}, name=#{name}, path=#{path}, price=#{price} where createDate=#{createDate}"})
    void updateGift(@Param("id") Integer id, @Param("status") int status, @Param("createDate") Date createDate);
	
    //获取所有礼物
    List<Gift> getLaterGift(int status);
}
