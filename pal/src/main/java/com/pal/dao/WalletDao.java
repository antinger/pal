package com.pal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.Wallet;

@Mapper
public interface WalletDao {
	
	String TABLE_NAME = "wallet";
    String INSERT_FIELDS = " username, balance ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{username},#{balance})"})
    void addWallet(Wallet wallet);
    
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    Wallet selectByUsername(String username);
    
    @Update({"update ", TABLE_NAME, " set balance=#{balance} where username=#{username}"})
    void updateWallet(@Param("username") String username, @Param("balance") int balance);
	
}
