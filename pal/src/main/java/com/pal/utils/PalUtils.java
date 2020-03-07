package com.pal.utils;

import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class PalUtils {
	
	public static void main(String[] args) {
		System.out.println(getRandomUUID());
	}
	
	public static boolean isEmtry(String str) {
		return str == null || "".equals(str);
	}
	
	public static String formatDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
	public static String getRandomUUID() {
    	return UUID.randomUUID().toString().replace("-", "");
    }
    
    public static String toJSONString(int code) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        return json.toJSONString();
    }
    
    public static String toJSONString(int code, String message) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("message", message);
        return json.toJSONString();
    }
    
    public static String toJSONString(int code, Map<String, Object> map) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        return json.toJSONString();
    }
    
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static final String[] IMAGE_FILE_EXTD = new String[] {"png", "bmp", "jpg", "jpeg"};
    public static boolean isFileAllowed(String fileName) {
        for (String ext : IMAGE_FILE_EXTD) {
            if (ext.equals(fileName)) {
                return true;
            }
        }
        return false;
    }
    

	public static String getIpAddress(HttpServletRequest request) {  
	    String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		    ip = request.getHeader("Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		    ip = request.getHeader("WL-Proxy-Client-IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		    ip = request.getHeader("HTTP_CLIENT_IP");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		    ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
		}  
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	        ip = request.getRemoteAddr();  
	    }
	    return ip;  
	}

}
