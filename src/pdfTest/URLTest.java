package pdfTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年12月29日 下午4:25:18
 * @version 1.0
 * @parameter
 * @since  
 * @return  */
public class URLTest {
	public  static void main(String []args){
		//10.198.18.239
		 String url ="http://openapi.xg.qq.com/v2/push/create_multipush?access_id=2100272892&message={'title':'测试消息','content':'来自restapi的批量接口测试消息','custom_content':{'key1':'value1','key2':'value2'}}&message_type=2&timestamp=1514799460&sign=d6d04d65439468ba47959a0a6afc305a";

		//String url ="http://10.10.1.61:6011/SunTRM/servlet/GetImage?ZGF0ZT0yMDE3MTIyOCZmaWxlX25hbWU9L2hvbWUvbWlkZGxld2FyZS9FQ01Gb2xkZXIvdGVtcDYwMDEvbXlzZW5kL3Jpc2tDb250cm9sLzIwMTcvMTIvMjgvMjgvNjYvMzY3RjEzNjQ1NTA0N0NDQTQzMzlGQUIwNjcwRkI2RTNfMS9EMjdFRTcxRS01N0U1LTMxMEYtQjZCOS1CNTA2NDAwMEVDNDguanBn";

//		String url="http://openapi.xg.qq.com/v2/push/create_multipush?access_id=2100272892&message={'title':'测试消息','content':'来自restapi的批量接口测试消息','custom_content':{'key1':'value1','key2':'value2'}}&message_type=2&timestamp=1514538677&sign=843c240ee0b620341ef96a0521ac3868";
		
//		String url="http://m.maoyan.com/showtime/wrap.json?cinemaid=1111&movieid=248680";
		try {
				//设置代理
//				InetSocketAddress addr = new InetSocketAddress("Proxy.piccnet.com.cn", 3128);
//				    // Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr); // Socket 代理
//				Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理
//				Authenticator.setDefault(new MyAuthenticator("71009832", "977BC3AC"));// 设置
	            URL oracle = new URL(url);
//	            URLConnection conn = oracle.openConnection(proxy);// proxy(使用代理)
	            URLConnection conn = oracle.openConnection();//或HttpURLConnection connect = (HttpURLConnection) connection.openConnection();  
	            conn.setRequestProperty("Content-type","application/x-www-form-urlencoded");
//	            conn.setRequestMethod("POST");
	            conn.setDoOutput(true);
	            conn.setRequestProperty("User-Agent","directclient");
	            InputStreamReader inputStreamReader=new InputStreamReader(conn.getInputStream());
	            BufferedReader br = new BufferedReader(inputStreamReader);  
	            String inputLine = null;  
	            while((inputLine = br.readLine()) != null){  
	                System.out.println(inputLine);  
	            }  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
		
//		String address= getURLContent(url);
//		getURL(url);
//		System.out.println("dizhi:"+address);
//		httpRequest(url,"GET");
		 		 
	}
	 static class MyAuthenticator extends Authenticator {
		    private String user = "";
		    private String password = "";
		    
		    public MyAuthenticator(String user, String password) {
		      this.user = user;
		      this.password = password;
		    }
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(user, password.toCharArray());
		    }
	}
	
	public static JSONObject httpRequest(String requestUrl, String requestMethod) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {

            URL url = new URL(requestUrl);
            // http协议传输
            HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            System.out.println("tostring:"+buffer.toString());
//            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
	
	public static String getURLContent(String urlStr) {             
        URL url = null;            
        //http连接
        HttpURLConnection httpConn = null;          
        //输入流
        BufferedReader in = null; 
        StringBuffer sb = new StringBuffer(); 
        try{
            url = new URL(urlStr);
            httpConn = (HttpURLConnection)url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setRequestProperty("User-Agent","directclient");
            httpConn.getInputStream();
            InputStreamReader inputStreamReader =  new InputStreamReader(httpConn.getInputStream(),"UTF-8");
            in = new BufferedReader(inputStreamReader); 
            String str = null;  
            while((str = in.readLine()) != null) {  
                sb.append( str );
            }
        } catch (Exception ex) {
            
        } finally{  
            try{           
                if(in!=null) {
                    in.close();   
                }
            }catch(IOException ex) {
                
            }
        }   
        String result =sb.toString();   
        //System.out.println(result);   
        return result;
    }
	public static void getURL(String urlStr){
		String surl = "";
		try {
	               surl=urlStr;
	               URL url = new URL(surl);
	               URLConnection rulConnection   = url.openConnection();
	               HttpURLConnection httpUrlConnection  =  (HttpURLConnection) rulConnection;
	               httpUrlConnection.setConnectTimeout(300000);
	               httpUrlConnection.setReadTimeout(300000);
	               httpUrlConnection.connect();	              
	               String code = new Integer(httpUrlConnection.getResponseCode()).toString();
	               String message = httpUrlConnection.getResponseMessage();
	               System.out.println("getResponseCode content ="+  httpUrlConnection.getContent());
	               System.out.println("getResponseCode code ="+ code);
	               System.out.println("getResponseMessage message ="+ message);
	               if(!code.startsWith("2")){
	                    throw new Exception("ResponseCode is not begin with 2,code="+code);
	               }
//	               System.out.println(getCurDateTime()+"连接"+surl+"正常");
	          }catch(Exception ex){
	               System.out.println(ex.getMessage());
	          }
	}
	
}
