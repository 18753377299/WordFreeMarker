package pdfTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年12月18日 下午5:17:30
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class TestWord {
	public static void main(String[] args){
        Freemark freemark = new Freemark("template/");//这里如果放在了具体的包名下，需要修改为 "/com/test/template/"
        freemark.setTemplateName("简历-朱老师.ftl");
        freemark.setFileName("doc_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date())+".doc");//生成的word名称
        freemark.setFilePath("D:/");//生成word存储路径
        freemark.createWord();//生成方法
    }
	private void createWord(){

        Template t = null;
        try {
            t = configuration.getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File outFile = new File(filePath+fileName);
        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map map = new HashMap<String, Object>();

        map.put("NAME", "韩满义");
//        map.put("image", getImageStr());
//
//        map.put("SEX", "男");
//        map.put("BIRTH", "1987-08");
//        map.put("ZZMM", "党员");
//        map.put("MZ", "汉");
//        map.put("JG", "河北省");
//        map.put("JKZK", "良好");
//        map.put("SG", "173cm");
//        map.put("HYZK", "已婚");
//        map.put("XL", "本科");
//        map.put("BYYX", "河北工业大学");
//        map.put("ZY", "软件工程");
//        map.put("ZP", "照片//todo");
//        map.put("QZYX", "软件方向工作薪资1w上下");
//        map.put("JYSH1", "06-09-01~10-06-20");
//        map.put("JYYZ1", "河北工业大学 软件工程");
//        map.put("JYXW1", "学士学位");
//        map.put("JYKC1", "软件工程、微积分、软件过程管理、数据库原理等等");
//
//        map.put("JYSH2", "10-07-01~至今");
//        map.put("JYYZ2", "ABCDE大学");
//        map.put("JYXW2", "XYZ学位");
//        map.put("JYKC2", "POI课程");
//
//        map.put("ZYJN", "软件开发、软件管理");
//
//        map.put("GZSH1", "10-07-01~11-12-09");
//        map.put("GZDZ1", "华信软件");
//        map.put("GZGY1", "初级软件工程师");
//
//        map.put("GZSH2", "11-12-15~14-4-05");
//        map.put("GZDZ2", "北京久其");
//        map.put("GZGY2", "高级软件工程师");
//
//        map.put("JLQK", "二三等奖学金、富士通奖学金等");
//        map.put("ZWPJ", "兴趣丰富、好奇心强、有研究精神。");
//
//        map.put("DH", "0312-3132098");
//        map.put("SJ", "15033768387");
//        map.put("YJ", "hanmanyifengyi@163.com");
//        map.put("DZ", "河北省保定市");
//        map.put("YB", "071000");

        try {
            t.process(map, out);
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	/**
     * freemark初始化
     * @param templatePath 模板文件位置
     */
    public  Freemark(String templatePath) {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(),templatePath);     
    } 
    /**
     * 得到图片
     * @return
     */
    private String getImageStr() {
        String imgFile = "D:/hanmanyi/pic/111.jpg";//需要在D盘下指定的目录下放一张图片
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
        BASE64Encoder encoder = new BASE64Encoder();//这里会报错
        return encoder.encode(data);
    }

    /**
     * freemark模板配置
     */
    private Configuration configuration;
    /**
     * freemark模板的名字
     */
    private String templateName;
    /**
     * 生成文件名
     */
    private String fileName;
    /**
     * 生成文件路径
     */
    private String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
