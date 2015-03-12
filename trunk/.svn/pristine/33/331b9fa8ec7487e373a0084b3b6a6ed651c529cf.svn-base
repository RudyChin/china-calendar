package com.china.calendar;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.util.Log;



/**
 * 
 * @explanation
 */
public class DateUtil {
	
	private static final String TAG = "DateUtil";

    /**
     * 
     * @time 5:51:36 PM
     * @param time
     * @param fromFormat
     * @param toFormat
     * @return
     * @throws ParseException
     * @throws 
     * @explanation change a date string from the fromFormat to toFormat
     */
    public static String formatDate(String time, String fromFormat,
            String toFormat) throws ParseException {
    	if (time == null || "".equals(time.trim()))
    		return null;
        String dateTime = time;

        SimpleDateFormat oldFormat = new SimpleDateFormat(fromFormat);
        SimpleDateFormat newFormat = new SimpleDateFormat(toFormat);

        String dataStr = null;

        dataStr = newFormat.format(oldFormat.parse(dateTime));

        return dataStr;
    }
    
    public static String formatDate(String time,String toFormat){
    	if (time == null || "".equals(time.trim()))
    		return "";
    	
    	String fromFormat = null;
    	if(time.length() == 6){
    		fromFormat = "HHmmss";
    	}else if(time.length()==8){
    		fromFormat = "yyyyMMdd";
    	}else if(time.length() == 14){
    		fromFormat = "yyyyMMddHHmmss";
    	}else{
    		return time;
    	}
    	SimpleDateFormat oldFormat = new SimpleDateFormat(fromFormat);
        SimpleDateFormat newFormat = new SimpleDateFormat(toFormat);
        try {
			return newFormat.format(oldFormat.parse(time));
		} catch (ParseException e) {
			Log.e(TAG,"date format error:"+time);
			return time;
		}
    }
    
    public static String formatDate(long time,String toFormat){
    	Date date = new Date(time);
    	SimpleDateFormat newFormat = new SimpleDateFormat(toFormat);
    	return newFormat.format(date);
    }

    /**
     * 
     * @time 10:43:46 AM
     * @return
     * @explanation get current date string meeting formatStr
     */
    public static String getCurrentDate(String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(new Date());
    }

    /**
     * 
     * @time 10:43:46 AM
     * @return
     * @explanation format date according to toFormat
     */
    public static String formatDate(Date date, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }
    
    /**
     * 当前时间到给定时间相差多少小时
     * @param before
     * @return
     */
    public static long spanHour(String before){
    	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		try {
			Date date = sf.parse(before);
			Calendar cale = Calendar.getInstance();
			cale.setTime(date);
			long beforeTime = cale.getTimeInMillis();
			
			GregorianCalendar   calendar   =   new   GregorianCalendar();   
			long   nowTime   =   calendar.getTimeInMillis();   
			long span = (nowTime - beforeTime)/(1000*60*60);
			return span;
			
		} catch (ParseException e) {
			return 0;
		}
    }
   
	public static void main(String args[]){
//		long interval = DateUtil.getInterval("16:00:00");
//		System.out.println(interval);
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -3);
		System.out.println( formatDate(calendar.getTime(),"yyyyMMddHHmmss"));
	}

    
}
