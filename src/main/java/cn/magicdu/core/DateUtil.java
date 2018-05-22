package cn.magicdu.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.magicdu.core.date.DatePattern;

/**
 * operate dates
 * @author magicdu
 * @Date 2018/05/22
 * @version 1.0.0
 */
public class DateUtil {
	
	
	private DateUtil(){}
	
	/**
	 * current date time
	 * @return
	 */
	public static Date date(){
		return new Date();
	}
	
	/**
	 *  the string of current date time
	 * @param pattern {@link DatePattern }
	 * @return
	 */
	public static String now(String pattern){
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		return format.format(date().getTime());
	}

	/**
	 * parse String to date
	 * @param pattern
	 * @return
	 */
	public static Date parseStrToDate(String pattern,String ...params){
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		try {
			for (String param:params){
				if (param!=null && "now".equals(param)){
					return format.parse(now(pattern));
				}
			}
			return format.parse(pattern);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date("1970-01-01 08:00:00");
	}

	
	public static void main(String[] args) {
		System.out.println(now(DatePattern.NORM_DATE_PATTERN));
		System.out.println(now(DatePattern.NORM_DATETIME_MINUTE_PATTERN));
		System.out.println(now(DatePattern.NORM_DATETIME_PATTERN));
	}
}
