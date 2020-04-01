package pdfTest;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年12月18日 下午5:35:06
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;

/*通过freemarker生成word文档成功案例*/

public class WordTest {

    private Configuration configuration = new Configuration();

//    public WordTest() {
//        configuration = new Configuration();
//        configuration.setDefaultEncoding("UTF-8");
//    }
    
    public static void main(String[] args) {
        WordTest test = new WordTest();
        test.createWord();
    }
    
    public void createWord() {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        
        try {
        	List<User> users=new ArrayList<User>();
        	Image image=new Image();
        	for(int i=0;i<3;i++){
        		User user =new User();
        		user.setName("aaaaad");
        		users.add(user);
        	}
//       	    String name="2wrwrtetedkgjfhkjghfjghfjghjfhgjfhjghfjghfjhgkjfhhjhfkjhfkjhkjfhjfkhfjhkfjhkfjhkfj";
        	String name="2";
       	    int rowSize=10;
       	    int rownum=1;
//       	    if(name.length()>rowSize){
//       	    	if()
//       	    }
        	dataMap.put("users", users);
        	dataMap.put("image", getImageStr());
            dataMap.put("name", name);
            dataMap.put("sex", "男");
        	java.net.URL url=WordTest.class.getClassLoader().getResource("/");
        	java.net.URL url2=WordTest.class.getClassLoader().getResource("/template");
            configuration.setClassForTemplateLoading(this.getClass(), "/template"); // FTL文件所存在的位置
            Template template = configuration.getTemplate("abc.ftl");
//            Template template = configuration.getTemplate("dddd.ftl");
//            Template template = configuration.getTemplate("dddd (2).ftl");

            File outFile = new File("D:/wordTest7.doc");// D:/temp2这个路径下的temp2文件夹是手动创建的
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  String getImageStr() {
//        String imgFile = "C:/Users/lqk/Desktop/p2.jpg";
        String imgFile = "C:/Users/lqk/Desktop/aa.png";
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imageCodeBase64 = Base64.encodeBase64String(data);
        return imageCodeBase64;
//        BASE64Encoder  endcoder=new sun.misc.BASE64Encoder();
//        return endcoder.encode(data);
    }

   
}