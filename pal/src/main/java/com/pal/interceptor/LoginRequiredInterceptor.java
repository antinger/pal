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

import com.pal.entity.HostHolder;
import com.pal.utils.PalUtils;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {
	
	@Autowired
    private HostHolder hostHolder;
	
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (hostHolder.getUser() == null) {
        	Map<String, Object> map = new HashMap<>();
        	map.put("url", "");
        	httpServletResponse.setContentType("text/html; charset=utf-8");
        	PrintWriter out = httpServletResponse.getWriter();
        	try {
        		out.write(PalUtils.toJSONString(302, map));
        		out.flush();
			} catch (Exception e) {
				
			} finally {
				out.close();
			}
            return false;
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
