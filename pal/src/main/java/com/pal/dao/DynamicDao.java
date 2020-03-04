package com.pal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.Dynamic;

@Mapper
public interface DynamicDao {
	
	String TABLE_NAME = "dynamic";
    String INSERT_FIELDS = " userID, sex, content, image, status, createDate ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userID},#{sex},#{content},#{image},#{status},#{createDate})"})
    int addDynamic(Dynamic dynamic);
    
    //更新动态状态
    @Update({"update ", TABLE_NAME, " set status=#{status} where id=#{id}"})
    void updateDynamic(@Param("id") Integer id, @Param("status") Integer status);
    
    //获取最新的动态
	List<Dynamic> getLaterDynamic(Integer page, Integer start, int sex, int status);
	
	//获取所有数据量
	@Select({"select count(*) from ", TABLE_NAME, " where status=#{status}"})
    int getLaterDynamicCount(int status);
	
}
