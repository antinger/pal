package com.pal.utils;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class VisaUtil {

	/*public static String getSHA256Encryption(String str) {
		String result = null;
		try {
			MessageDigest mesd = MessageDigest.getInstance("SHA-256");
			result = byte2hexString(mesd.digest(str.getBytes("ISO-8859-1")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return result;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	public static String byte2hexString(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}
	
	public static DefaultHttpClient getHttpClient() {
		
		DefaultHttpClient httpclient = new DefaultHttpClient();
		
		X509TrustManager xtm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				
			}
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				
			}
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};
		// TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
		SSLContext ctx = null;
		try {
		ctx = SSLContext.getInstance("TLS");
		ctx.init(null, new TrustManager[] { xtm }, null);
		} catch (NoSuchAlgorithmException e1) {
			
		} catch (KeyManagementException e) {
			
		}
		// 创建SSLSocketFactory
		SSLSocketFactory socketFactory = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));
		return httpclient;
	}*/
	
}
