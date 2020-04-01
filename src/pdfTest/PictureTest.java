package pdfTest;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年12月28日 下午2:34:14
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class PictureTest {
   public static void main(String[]args) throws Exception{ 
	   //把网络图片转换为本地图片
//	   http://10.10.1.61:6011/SunTRM/servlet/GetImage?ZGF0ZT0yMDE3MTIyOCZmaWxlX25hbWU9L2hvbWUvbWlkZGxld2FyZS9FQ01Gb2xkZXIvdGVtcDYwMDEvbXlzZW5kL3Jpc2tDb250cm9sLzIwMTcvMTIvMjgvMjgvNjYvMzY3RjEzNjQ1NTA0N0NDQTQzMzlGQUIwNjcwRkI2RTNfMS9EMjdFRTcxRS01N0U1LTMxMEYtQjZCOS1CNTA2NDAwMEVDNDguanBn
//	   String aa="http://pic76.nipic.com/file/20150826/19291311_131811815000_2.jpg";
	   String aa="http://10.10.1.61:6011/SunTRM/servlet/GetImage?ZGF0ZT0yMDE3MTIyOCZmaWxlX25hbWU9L2hvbWUvbWlkZGxld2FyZS9FQ01Gb2xkZXIvdGVtcDYwMDEvbXlzZW5kL3Jpc2tDb250cm9sLzIwMTcvMTIvMjgvMjgvNjYvMzY3RjEzNjQ1NTA0N0NDQTQzMzlGQUIwNjcwRkI2RTNfMS9EMjdFRTcxRS01N0U1LTMxMEYtQjZCOS1CNTA2NDAwMEVDNDguanBn";
	   URL url=new URL(aa);

	   DataInputStream dataInputStream=new DataInputStream(url.openStream());
	   String imageName="D:/cccc.png";
	   FileOutputStream fileOutputStream=new FileOutputStream(new File(imageName));
	   byte[]buffer=new byte[1024];
	   int length;
	   while ((length=dataInputStream.read(buffer))>0) {
		  fileOutputStream.write(buffer,0,length);		
	   }
	   fileOutputStream.close();
	   dataInputStream.close();	   
   }
}
