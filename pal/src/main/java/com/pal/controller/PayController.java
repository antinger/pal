package com.pal.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.pal.async.EventModel;
import com.pal.async.EventProducer;
import com.pal.async.EventType;
import com.pal.utils.PalUtils;
import com.pal.utils.PaypalConfig;

@Controller
public class PayController {
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	@Autowired
	EventProducer eventProduce;
	
	@RequestMapping(path="/paysuccess/", method=RequestMethod.POST)
	@ResponseBody
	public String paysuccess(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		try {
			Map<String, Object> map = null;
			Enumeration<String> parameterNames = request.getParameterNames();
			String str = "cmd=_notify-validate";
			while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = request.getParameter(paramName);
                //此处的编码一定要和自己的网站编码一致，不然会出现乱码，paypal回复的通知为‘INVALID’
                str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue, "UTF-8");
            }
			
			URL u = new URL(PaypalConfig.getWebscr());
            HttpURLConnection uc = (HttpURLConnection) u.openConnection();
            uc.setRequestMethod("POST");
            uc.setDoOutput(true);
            uc.setDoInput(true);
            uc.setUseCaches(false);
            //设置 HTTP 的头信息
            uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            PrintWriter pw = new PrintWriter(uc.getOutputStream());
            pw.println(str);
            pw.close();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String res = in.readLine();
            in.close();

            /**
             	* 将 POST 信息分配给本地变量，可以根据您的需要添加
             */
            // 交易状态 Completed 代表交易成功
            String paymentStatus = request.getParameter("payment_status");
            // 交易时间
            String paymentDate = request.getParameter("payment_date");
            // 交易id
            String txnId = request.getParameter("txn_id");
            // 父交易id
            String parentTxnId = request.getParameter("parent_txn_id");
            // 收款人email
            String receiverEmail = request.getParameter("receiver_email");
            // 收款人id
            String receiverId = request.getParameter("receiver_id");
            // 付款人email
            String payerEmail = request.getParameter("payer_email");
            // 付款人id
            String payerId = request.getParameter("payer_id");
            // 交易金额
            String mcGross = request.getParameter("mc_gross");
            // 自定义字段，我们存放的订单ID
            String custom = request.getParameter("custom");
            eventProduce.fireEvent(new EventModel().setEventType(EventType.PAY).setExts("custom", custom));
            
            logger.error("获取自定义字段" + custom);
            
			return PalUtils.toJSONString(200, map);
		} catch (Exception e) {
			logger.error("paypal支付失败" + e.getMessage());
			return PalUtils.toJSONString(500, "获取推送用户失败");
		}
	}
	
}
