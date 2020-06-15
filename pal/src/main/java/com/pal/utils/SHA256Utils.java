package com.pal.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Utils {
	/**
	 * 实现：SHA-256加密工具
	 * @param str 需要加密的参数
	 * @return 加密后的密文
	 */
	public static String getSHA256Encryption(String str) {
		String result = null;
		try {
			MessageDigest mesd = MessageDigest.getInstance("SHA-256");
			result = byte2hexString(mesd.digest(str.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return result;
		}  catch (UnsupportedEncodingException e) {
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
	public static void main(String[] args) {
		System.out.println(SHA256Utils.getSHA256Encryption("EncryptionMode=SHA256&CharacterSet=UTF8&merNo=10868&terNo=88826&orderNo=www.camisetadefútbolbaratas.com-7&currencyCode=EUR&amount=30.50&payIP=116.30.222.112&transType=sales&transModel=M&5260b4edf7904b53bcc481afe239363e"));
		
	}
}
