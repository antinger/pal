package com.pal.entity;


import org.springframework.stereotype.Component;

@Component
public class HostHolder {
	
	//本地用户保存
    private static ThreadLocal<User> users = new ThreadLocal<User>();
    
    public static User getUser() {
        return users.get();
    }
    
    public static void setUser(User user) {
        users.set(user);
    }
    
    public static void clear() {
        users.remove();;
    }
    
}