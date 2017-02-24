package com.huchaishi.common;

import java.text.SimpleDateFormat;
import com.avatar.gdk.util.StringUtils;


public class ComMethods {
	
	/**
	 * 将时间戳转为时间
	 * 
	 * @param timeStr
	 * @return
	 */
	public static String parse2DateStr(String timeStr) {
		try {
			if (StringUtils.isEmpty(timeStr)) {
				return "";
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Long time = new Long(timeStr);
			String date = sdf.format(time * 1000);
			return date;
		} catch (Exception e) {
			System.out.println("error:"+e);
			return "";
		}
	}

}
