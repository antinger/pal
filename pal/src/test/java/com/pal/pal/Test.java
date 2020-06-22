package com.pal.pal;

import java.util.Date;

import com.pal.utils.PalUtils;

public class Test {

	public static void main(String[] args) {
		Long expired = new Date().getTime();
		System.out.println(PalUtils.formatDate(new Date()));
		System.out.println(expired);
		long times = 1000L * 3600 * 24 * 30;
		System.out.println(times);
		expired = expired + times;
		System.out.println(expired);
		Date time = new Date(expired);
		System.out.println(PalUtils.formatDate(time));
	}
	
}
