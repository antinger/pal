package com.pal.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.pal.entity.WalletOrder;

@Mapper
public interface WalletOrderDao {
		
	String TABLE_NAME = "walletOrder";
    String INSERT_FIELDS = " card, userName, toUserName, content, price, createDate ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{card},#{userName},#{toUserName},#{content},#{price},#{createDate})"})
    void addWalletOrder(WalletOrder walletOrder);
    
}
