package com.pal.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.pal.entity.HostHolder;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pal.async.EventModel;
import com.pal.async.EventProducer;
import com.pal.async.EventType;
import com.pal.utils.PalUtils;
import com.pal.utils.SHA256Utils;

@Controller
public class VisaPayController {
	
	private static final Logger logger = LoggerFactory.getLogger(VisaPayController.class);
	//cardCountry, cardState, cardCity, cardAddress, cardZipCode
	//grCountry, grState, grCity, grAddress, grZipCode, grEmail, grphoneNumber, grPerName
	//cardNO, expYear, expMonth, cvv, cardFullName, cardFullPhone
	@Autowired
	HostHolder HostHolder;
	
	@Autowired
	EventProducer eventProducer;
	
	@RequestMapping(path="/user/payVisa/", method=RequestMethod.POST)
	@ResponseBody
	public String payVisa(@RequestParam("cardCountry") String cardCountry
			, @RequestParam("cardState") String cardState, @RequestParam("cardCity") String cardCity
			, @RequestParam("cardAddress") String cardAddress, @RequestParam("custom") String custom
			, @RequestParam("cardZipCode") String cardZipCode, @RequestParam("grCountry") String grCountry
			, @RequestParam("grState") String grState, @RequestParam("grCity") String grCity
			, @RequestParam("grAddress") String grAddress, @RequestParam("grZipCode") String grZipCode
			, @RequestParam("grEmail") String grEmail, @RequestParam("grphoneNumber") String grphoneNumber
			, @RequestParam("grPerName") String grPerName, @RequestParam("cardNO") String cardNO
			, @RequestParam("expYear") String expYear, @RequestParam("expMonth") String expMonth
			, @RequestParam("cvv") String cvv, @RequestParam("FristName") String FristName, @RequestParam("LastName") String LastName
			, @RequestParam("cardFullPhone") String cardFullPhone) {
		Map<String, Object> map = new HashMap<>();
		String payIP = HostHolder.getUser().getAddress();
		if(!PalUtils.emailFormat(grEmail)) {
			map.put("err", "请输入有效邮箱");
			return PalUtils.toJSONString(500, map);
		}
		if(expYear.length() != 4) {
			map.put("err", "请输入有效时间");
			return PalUtils.toJSONString(500, map);
		}
		if(expMonth.length() != 2) {
			map.put("err", "请输入有效时间");
			return PalUtils.toJSONString(500, map);
		}
		if(!PalUtils.regexTel(cardFullPhone)) {
			map.put("err", "请输入有效的手机号");
			return PalUtils.toJSONString(500, map);
		}
		if(expYear.length() != 4) {
			map.put("err", "请输入有效的年份");
			return PalUtils.toJSONString(500, map);
		}
		if(expMonth.length() != 2) {
			map.put("expMonth", "请输入有效的月份");
			return PalUtils.toJSONString(500, map);
		}
		String[] customs = custom.split("&");
		String amount = customs[3];
		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		String cardFullName = FristName + "." + LastName;
		String orderNo = PalUtils.getRandomUUID();
		//商家号
		nvps.add(new BasicNameValuePair("merNo", "339888"));
		//终端号
		nvps.add(new BasicNameValuePair("terNo", "88816"));
		//交易类型
		nvps.add(new BasicNameValuePair("transType","sales"));
		//模式(固定值-M)
		nvps.add(new BasicNameValuePair("transModel","M"));
		//消费金额
		nvps.add(new BasicNameValuePair("amount", String.valueOf(amount)));
		//订单币种
		nvps.add(new BasicNameValuePair("currencyCode", "USD"));
		//订单号
		nvps.add(new BasicNameValuePair("orderNo", orderNo));
		//订单备注参数
		nvps.add(new BasicNameValuePair("merremark", "US order."));
		//网店系统接收支付结果地址
		nvps.add(new BasicNameValuePair("returnURL", "http://www.asecretdates.com/visaSuccess/"));
		//网店系统的网址
		nvps.add(new BasicNameValuePair("merMgrURL", "www.asecretdates.com"));
		//消费者浏览器信息
		nvps.add(new BasicNameValuePair("webInfo", "userAgent:Mozilla"));
		//支付页面默认显示的语言
		nvps.add(new BasicNameValuePair("language", "en_US"));
		//账单签收国家（国家代码-两位）
		nvps.add(new BasicNameValuePair("cardCountry", cardCountry));
		//账单签收州cardCountry, cardState, cardCity, cardAddress, cardZipCode
		nvps.add(new BasicNameValuePair("cardState", cardState));
		//账单签收城市
		nvps.add(new BasicNameValuePair("cardCity", cardCity));
		//账单签收人地址
		nvps.add(new BasicNameValuePair("cardAddress", cardAddress));
		//账单邮编
		nvps.add(new BasicNameValuePair("cardZipCode", cardZipCode));
		//收货国家（国家代码-两位）grCountry, grState, grCity, grAddress, grZipCode, grEmail, grphoneNumber, grPerName
		nvps.add(new BasicNameValuePair("grCountry", grCountry));
		//收货州
		nvps.add(new BasicNameValuePair("grState", grState));
		//收货城市
		nvps.add(new BasicNameValuePair("grCity", grCity));
		//支付时持卡人网络的真实IP地址
		nvps.add(new BasicNameValuePair("payIP", payIP));
		//收货地址
		nvps.add(new BasicNameValuePair("grAddress", grAddress));
		//收货邮编
		nvps.add(new BasicNameValuePair("grZipCode", grZipCode));
		//收货邮箱
		nvps.add(new BasicNameValuePair("grEmail", grEmail));
		//收货人电话
		nvps.add(new BasicNameValuePair("grphoneNumber", grphoneNumber));
		//收货人姓名
		nvps.add(new BasicNameValuePair("grPerName", grPerName));
		//货物信息
		nvps.add(new BasicNameValuePair("goodsString", "goodsString"));
		//消费的信用卡卡号 cardNO, expYear, expMonth, cvv, cardFullName, cardFullPhone
		nvps.add(new BasicNameValuePair("cardNO", cardNO));
		//信用卡有效期年份（4位）
		nvps.add(new BasicNameValuePair("expYear", expYear));
		//信用卡有效期月份（2位）
		nvps.add(new BasicNameValuePair("expMonth", expMonth));
		//信用卡背面的cvv
		nvps.add(new BasicNameValuePair("cvv", cvv));
		//FristName.LastName (中间用点连接)
		nvps.add(new BasicNameValuePair("cardFullName", cardFullName));
		//持卡人电话
		nvps.add(new BasicNameValuePair("cardFullPhone", cardFullPhone));
		// 固定字段验签验签
		StringBuffer sb1 = new StringBuffer();
		sb1.append("EncryptionMode=SHA256&");
		sb1.append("CharacterSet=UTF8&");
		sb1.append("merNo=339888&");
		sb1.append("terNo=88816&");
		sb1.append("orderNo=" + orderNo + "&");
		sb1.append("currencyCode=USD&");
		sb1.append("amount=" + amount + "&");
		sb1.append("payIP=" + payIP + "&");
		sb1.append("transType=sales&");
		sb1.append("transModel=M&");
		sb1.append("d436dc909f2544359b31bd44d6b04908");
		String SHA = SHA256Utils.getSHA256Encryption(sb1.toString());
		nvps.add(new BasicNameValuePair("hashcode", SHA));
		
		// 创建httpClient实例对象
		DefaultHttpClient httpClient = new DefaultHttpClient(); 
		HttpPost postMethod = new HttpPost("https://payment.bringallpay.com/payment/api/payment");
		postMethod.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
		try {
			HttpResponse resp = httpClient.execute(postMethod); // 处理发送
			int statusCode = resp.getStatusLine().getStatusCode();
			HttpEntity entity = resp.getEntity();
			InputStream inSm = entity.getContent();
			Scanner inScn = new Scanner(inSm);
			String resultJson = null;
			if (inScn.hasNextLine()) {
				resultJson = inScn.nextLine();
			}
			JSONObject json = JSON.parseObject(resultJson);
			if ("00".equals(json.getString("respCode"))) {
				logger.error("visa支付成功" + json.toJSONString());
				map.put("info", "ok");
				eventProducer.fireEvent(new EventModel().setEventType(EventType.VISA).setExts("custom", custom));
				return PalUtils.toJSONString(200, map);
			} else {
				logger.error("visa支付失败" + json.toJSONString());
				// 支付失败，调用网店的业务代码
				map.put("err", "fail");
				return PalUtils.toJSONString(500, map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
