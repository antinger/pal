package com.pal.utils;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

 
/**
 * 根据IP地址获取详细的地域信息 
 *      也可通过 http://whois.pconline.com.cn/ 获取地址信息
 * 
 * 作者: zhoubang 
 * 日期：2015年8月7日 上午10:25:00
 */
public class AddressUtils {
	
    public static String getAddressByIP(String ip) {
    	String location = "";
        try {
            URL url = new URL("https://www.ip.cn/?ip=" + ip);
            HttpURLConnection  httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestProperty("Accept", "*/*");    
            httpConn.setRequestProperty("Connection", "Keep-Alive");    
            httpConn.setRequestProperty("User-Agent",    
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");    
            BufferedReader reader = new BufferedReader(new InputStreamReader(
            		httpConn.getInputStream(), "UTF-8"));
            String line = null;
            StringBuffer result = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
            Document root = Jsoup.parse(result.toString());
            Element resultRoot = root.getElementById("result");
            Elements codes = resultRoot.getElementsByTag("code");
            String text = codes.get(1).text();
            String[] split = text.split(" ");
            location = split[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }
}