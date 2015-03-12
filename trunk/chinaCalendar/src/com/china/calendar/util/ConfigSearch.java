package com.china.calendar.util;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConfigSearch {
	
	
	
	private static String content;
	
	private static String getString(InputStream is) {
        InputStreamReader r = null;
        try {
            StringBuilder sb = new StringBuilder();
            //TODO 这里是固定把网页内容的编码写在GBK,应该是可设置的
            r = new InputStreamReader(is, "UTF-8");
            char[] buffer = new char[128];
            int length = -1;
            while ((length = r.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, length));
            }
            return sb.toString();
        } catch (Exception ex) {           
            return "";
        } finally {
            try {
                r.close();
            } catch (Exception ex) {
            	return "";
            }
        }
    }
	
	/**
	 * 取参数，请先确保调用了searchParams 
	 * 网络原因取不到，则返回-1
	 * @param key
	 * @return
	 */
	public static int getParams(String key){		
		if(content!=null){
			String[] lines = content.split("\r\n");
			for(int i=0;i<lines.length;i++){
				if(lines[i].indexOf(key)!=-1){
					String[] vals = lines[i].split("=");
					if(vals.length>1){
						return Integer.valueOf(vals[1]);
					}
				}
			}
		}else{
			return -1;
		}
		return 0;
	}
	
	
	/**
	 * 先调用此函数查询出参数
	 * @return
	 */
	public static String searchParams() {		
		HttpURLConnection conn = null;
		InputStream in = null;
		String ret = null;
		try {
			URL url = new URL("http://china-calendar.googlecode.com/svn/trunk/chinaCalendar/config.properties");
			conn = (HttpURLConnection)url.openConnection();   
			conn.addRequestProperty("content-type","text/html;charset=UTF-8");
			conn.setRequestMethod("GET");  		
			in = conn.getInputStream();	
			ret = getString(in);
			conn.disconnect();
			in.close();	
		} catch (Exception e) {
			content = null;
			return null;
		}  	
		content = ret;
		return ret;	
	}
	
	public static void main(String args[]){
		System.out.println(ConfigSearch.searchParams());
		System.out.println(ConfigSearch.getParams("maxMonthClick"));
	}

}
