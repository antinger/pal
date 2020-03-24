package com.pal.controller;

import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pal.utils.PalUtils;

@Controller
public class PayController {
	
	@RequestMapping(path="/paysuccess/", method=RequestMethod.POST)
	@ResponseBody
	public String paysuccess(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("支付成功---------");
			Enumeration<String> parameterNames = request.getParameterNames();
			String str = "cmd=_notify-validate";
			while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName);
                //此处的编码一定要和自己的网站编码一致，不然会出现乱码，paypal回复的通知为‘INVALID’
                str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue, "UTF-8");
            }
			System.out.println("paypal传递过来的交易信息:" + str);
			Map<String, Object> map = null;
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
