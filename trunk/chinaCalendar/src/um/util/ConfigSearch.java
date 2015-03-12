package um.util;


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
	
	
	
	public static String searchParams() {		
		HttpURLConnection conn = null;
		InputStream in = null;
		String ret = null;
		try {
			URL url = new URL("http://baidu-bang.googlecode.com/svn/trunk/bang/config.properties");
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
