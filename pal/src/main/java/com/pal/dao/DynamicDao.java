package com.pal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.pal.entity.Dynamic;

@Mapper
public interface DynamicDao {
	
	String TABLE_NAME = "dynamic";
    String INSERT_FIELDS = " userID, sex, content, image, status, createDate ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userID},#{sex},#{content},#{image},#{status},#{createDate})"})
    int addDynamic(Dynamic dynamic);
    
    //获取最新的动态
	List<Dynamic> getLaterDynamic(Integer start, Integer limit, int sex, int status);
	
	//获取所有数据量
	@Select({"select count(*) from ", TABLE_NAME, " where status=#{status}"})
    int getLaterDynamicCount(int status);
	
	//根据用户ID获取数据
	List<Dynamic> getDynamicByUserID(Integer userID, int status);
}
