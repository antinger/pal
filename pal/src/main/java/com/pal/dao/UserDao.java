package com.pal.dao;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pal.entity.User;

@Mapper
public interface UserDao {
	
	String TABLE_NAME = "user";
    String INSERT_FIELDS = " username, email, password, salt, headLink, sex, createDate, onLineStatus, updateDate, status, headStatus, pushStatus, lineID, address ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    
    //添加用户
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{username},#{email},#{password},#{salt},#{headLink},#{sex},#{createDate},#{onLineStatus},#{updateDate},#{status},#{headStatus},#{pushStatus},#{lineID},#{address})"})
    void addUser(User user);
    
    //获取用户
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where username=#{username}"})
    User selectUserByUsername(String username);
    
    //获取用户
    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME, " where id=#{id}"})
    User selectUserByID(Integer id);
    
    //更新账号状态
    @Update({"update ", TABLE_NAME, " set status=#{status} where id=#{id}"})
    void updateStatus(@Param("id") Integer id, @Param("status") int status);
	
    //更新最新登录时间
    @Update({"update ", TABLE_NAME, " set updateDate=#{updateDate} where id=#{id}"})
    void updateDate(@Param("id") Integer id, @Param("updateDate") Date updateDate);
    
    //更新账号在线，离线，隐身状态
    @Update({"update ", TABLE_NAME, " set onLineStatus=#{onLineStatus} where id=#{id}"})
    void updateOnLineStatus(@Param("id") Integer id, @Param("onLineStatus") int onLineStatus);
    
    //更新头像状态
    @Update({"update ", TABLE_NAME, " set headStatus=#{headStatus} where id=#{id}"})
    void updateHeadStatus(@Param("id") Integer id, @Param("headStatus") int headStatus);
    
    //更新头像地址
    @Update({"update ", TABLE_NAME, " set headLink=#{headLink} where id=#{id}"})
    void updateHeadLink(@Param("id") Integer id, @Param("headLink") String headLink);
    
    //获取推送的用户
    List<User> getPushUsers(int pushStatus, int sex, int status);
    
    //获取首页展示的用户
    List<User> getLaterUser(int status, int sex, int start, int limit);
    
    //获取首页用户数量
    @Select({"select count(*) from ", TABLE_NAME, " where sex=#{sex} and status=#{status}"})
    int getLaterUserCount(int status, int sex);

    //更新用户密码
    @Update({"update ", TABLE_NAME, " set password=#{password} where id=#{id}"})
	void updatePassword(Integer id, String password);
    
}
