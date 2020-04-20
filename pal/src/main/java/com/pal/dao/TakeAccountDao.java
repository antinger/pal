package com.pal.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.TakeAccount;

@Mapper
public interface TakeAccountDao {
	
	String TABLE_NAME = "takeAccount";
    String INSERT_FIELDS = " card ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    TakeAccount selectAdminByID(Integer id);
    
}
