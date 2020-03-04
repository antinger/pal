package com.pal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.Encrypted;

@Mapper
public interface EncryptedDao {
	
	String TABLE_NAME = "encrypted";
    String INSERT_FIELDS = " username, name, email, like ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{username},#{name},#{email},#{like})"})
    int addEncrypted(Encrypted encrypted);
    
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    Encrypted selectByUsername(String username);
    
    @Update({"update ", TABLE_NAME, " set name=#{name}, email=#{email}, like=#{like} where username=#{username}"})
    void updateEncrypted(@Param("username") String username, @Param("name") String name, @Param("email") String email, @Param("like") String like);
	
}
