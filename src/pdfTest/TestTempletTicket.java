/**
 *@Title: TestTempletTicket.java   测试类
 *@Package: org.csun.ns.util
 *@Description: TODO
 *@Author: chisj chisj@foxmail.com
 *@Date: 2016年4月27日下午1:31:23
 *@Version V1.0
 */
package pdfTest;
 
import java.io.File;
 
/**
 *@ClassName: TestTempletTicket
 *@Description: TODO
 *@Author: chisj chisj@foxmail.com
 *@Date: 2016年4月27日下午1:31:23
 */
public class TestTempletTicket {
 
         public static void main(String[] args) throws Exception {
                  
                   Ticket ticket = new Ticket(); 
                   PDFTempletTicket pdfTT = new PDFTempletTicket();
                   for(int i=0;i<3;i++){
                	  ticket.setTicketId("2016042710000");
                      ticket.setTicketCreateTime("2016年4月27日");
                      ticket.setTicketCompany("武汉日创科技有限公司");
                      ticket.setSysName("智能看护系统");
                      ticket.setMoneyLittle("50,000.00");
                      ticket.setMoneyBig("伍万元整");
                      ticket.setAccountCompany("洪山福利院");
                      ticket.setBedNumber("500床位");
                      ticket.setUsername("qiu");
                      ticket.setPassword("12345634343434343434 \n"+"111111 \n");
                   }
                                    
                 
                  
                   pdfTT.setTemplatePdfPath("D:\\aaaa.pdf");
                   pdfTT.setTargetPdfpath("D:\\aaabbbb.pdf");
                   pdfTT.setTicket(ticket);
                  
                   File file = new File("D:\\aaabbbb.pdf");
                   file.createNewFile();
                   pdfTT.templetTicket(file);
                  
                   //OSSConfigureconfig = OSSUtil.getOSSConfigure();
       //OSSManageUtil.uploadFile(config, file, "aaabbbccc.pdf","pdf", "ticket/" + "aaabbbccc");
       
       //System.out.println("path = " + config.getAccessUrl());
                  
         }
        
}