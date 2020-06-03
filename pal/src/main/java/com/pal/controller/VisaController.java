package com.pal.controller;

import java.util.List;

public class VisaController {

	/*public void pay() {
		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		nvps.add(new BasicNameValuePair("merNo", "1888"));
		nvps.add(new BasicNameValuePair("terNo", "88816"));
		nvps.add(new BasicNameValuePair("transType","sales"));
		nvps.add(new BasicNameValuePair("transModel","M"));
		nvps.add(new BasicNameValuePair("amount", "98.99"));
		nvps.add(new BasicNameValuePair("currencyCode", "USD"));
		nvps.add(new BasicNameValuePair("orderNo", "2099828312"));
		nvps.add(new BasicNameValuePair("merremark", "US order."));
		nvps.add(new BasicNameValuePair("returnURL", "https://www.yourshop.com/result.php"));
		nvps.add(new BasicNameValuePair("merMgrURL", "www.yourshop.com"));
		nvps.add(new BasicNameValuePair("webInfo", "userAgent:Mozilla 5.0 (Windows NT 6.3; WOW64; rv:40.0) Gecko 20100101 Firefox 40.0"));
		nvps.add(new BasicNameValuePair("language", "en_US"));
		nvps.add(new BasicNameValuePair("cardCountry", "US"));
		nvps.add(new BasicNameValuePair("cardState", "California"));
		nvps.add(new BasicNameValuePair("cardCity", "ST Fremont"));
		nvps.add(new BasicNameValuePair("cardAddress", "Moor Building 35274 State ST Fremont. U.S.A"));
		nvps.add(new BasicNameValuePair("cardZipCode", "94538"));
		nvps.add(new BasicNameValuePair("grCountry", "US"));
		nvps.add(new BasicNameValuePair("grState", "California"));
		nvps.add(new BasicNameValuePair("grCity", "ST Fremont"));
		nvps.add(new BasicNameValuePair("payIP", "221.28.123.123"));
		nvps.add(new BasicNameValuePair("grAddress", "Moor Building 35274 State ST Fremont. U.S.A"));
		nvps.add(new BasicNameValuePair("grZipCode", "94538"));
		nvps.add(new BasicNameValuePair("grEmail", "test@123.com"));
		nvps.add(new BasicNameValuePair("grphoneNumber", "189813234434"));
		nvps.add(new BasicNameValuePair("grPerName", "sam.green"));
		nvps.add(new BasicNameValuePair("goodsString", "{"goodsInfo":[{"goodsName":"test1", "quantity":"2","goodsPrice":"15.2"}, {"goodsName":"test2", "quantity":"2","goodsPrice":"15.2"}, {"goodsName": "test3", "quantity":"2","goodsPrice":"15.2"}]}"));
		nvps.add(new BasicNameValuePair("cardNO", "4444333322221111"));
		nvps.add(new BasicNameValuePair("expYear", "2022"));
		nvps.add(new BasicNameValuePair("expMonth", "06"));
		nvps.add(new BasicNameValuePair("cvv", "123"));
		nvps.add(new BasicNameValuePair("cardFullName", "sam.green"));
		nvps.add(new BasicNameValuePair("cardFullPhone", "189813234434"));
		// 固定字段验签验签
		StringBuffer sb1 = new StringBuffer();
		sb1.append("EncryptionMode=SHA256&");
		sb1.append("CharacterSet=UTF8&");
		sb1.append("merNo=1888&");
		sb1.append("terNo=88816&");
		sb1.append("orderNo=2099828312&");
		sb1.append("currencyCode=USD&");
		sb1.append("amount=98.99&");
		sb1.append("payIP=221.28.123.123&");
		sb1.append("transType=sales&");
		sb1.append("transModel=M&");
		sb1.append("9e3870716b3e4e939dcc254bce0cec9a");
		String SHA = SHA256Utils.getSHA256Encryption(sb1.toString());
		nvps.add(new BasicNameValuePair("hashcode", SHA));
		DefaultHttpClient httpClient = Tools.getHttpClient(); // 建立客户端连接
		HttpPost postMethod = new HttpPost("https://sslpayment.bringallpay.com/payment/api/payment");
		postMethod.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
		int statusCode = 0;
		try {
			HttpResponse resp = httpClient.execute(postMethod); // 处理发送
			statusCode = resp.getStatusLine().getStatusCode();
			HttpEntity entity = resp.getEntity();
			InputStream inSm = entity.getContent();
			Scanner inScn = new Scanner(inSm);
			String resultJson = null;
			if (inScn.hasNextLine()) {
				resultJson = inScn.nextLine();
			}
			JSONObject json = JSON.parseObject(resultJson);
			if ("00".equals(json.getString("respCode"))) {
				// 支付成功，调用网店的业务代码
			} else {
				// 支付失败，调用网店的业务代码
			}
		} catch (ClientProtocolException e) {
			logger.info(info.getTradeNo() + ":payment failed！");
			throw new ShopException("1000", "payment failed");
		} catch (IOException e) {
			logger.info(info.getTradeNo() + ":payment failed！");
			throw new ShopException("1000", "payment failed");
		} catch (Exception e) {
			logger.info(info.getTradeNo() + ":payment failed！");
			throw new ShopException("1000", "payment failed");
		} finally {
			// 关闭连接
		}
	}
	*/
}
