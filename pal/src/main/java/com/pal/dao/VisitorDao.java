package com.pal.dao;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.pal.entity.Visitor;

@Mapper
public interface VisitorDao {
	
	String TABLE_NAME = "visitor";
    String INSERT_FIELDS = " userID, visitorID ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加游客
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{userID},#{visitorID})"})
    int addVistor(Visitor visitor);
    
    //获取游客
	List<Visitor> getVistor(Integer visitorID);
	
}
