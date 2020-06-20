package com.pal.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pal.dao.UserDao;
import com.pal.entity.HostHolder;
import com.pal.entity.User;
import com.pal.utils.PalUtils;

@Component
public class UserOnLineStatusInterceptor implements HandlerInterceptor {
	
	@Autowired
    private HostHolder hostHolder;
	
	@Autowired
	UserDao userDao;
	
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = hostHolder.getUser();
        Integer onLineStatus = user.getOnLineStatus();
        if (onLineStatus == 2) {
        	userDao.updateOnLineStatus(user.getId(), 0);
		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    
    }

}
