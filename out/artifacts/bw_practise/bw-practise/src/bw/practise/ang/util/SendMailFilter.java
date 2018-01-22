package bw.practise.ang.util;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

public class SendMailFilter {
	private static String MAIL_ADDRESS = "827021353@qq.com";
	private static String MAIL_USERNAME = "827021353@qq.com";
	private static String MAIL_PASSWORD = "glvwewqqdgerbbga";
	private static String MAIL_SERVER = "smtp.qq.com";
	
	public static void sendMailFilter(String mail_address,String mail_title,File mail_file,String mail_content,String file_name){
		
		Properties pro = new Properties();
		
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		pro.put("mail.smtp.host", MAIL_SERVER);
		// 同时通过验证
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.port", "25");
		pro.setProperty("mail.transport.protocol", "smtp");
		
		//腾讯邮箱增加验证
				MailSSLSocketFactory sf = null;
				try {
					sf = new MailSSLSocketFactory();
					sf.setTrustAllHosts(true);
					pro.put("mail.smtp.ssl.enable", "true");
					pro.put("mail.smtp.ssl.socketFactory", sf);
				} catch (GeneralSecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// 如果需要身份认证，则创建一个密码验证器
				authenticator = new MyAuthenticator(MAIL_USERNAME,MAIL_PASSWORD);
		
	    //或许系统的属性
		java.util.Properties properties = System.getProperties();
		//设置邮件的服务器
		properties.setProperty("mail.smtp.host",MAIL_SERVER);
		//获取默认的session值
		javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties);
		try {
			//创建默认的MimeMessage对象
			MimeMessage message = new MimeMessage(session);
			//头部字段
			message.setFrom(new InternetAddress(MAIL_USERNAME));
			//头部字段
	        message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(mail_title));
	        //创建消息
	        BodyPart messageBodyPart = new MimeBodyPart();
	        //添加消息内容
	        messageBodyPart.setContent(mail_content, "text/html; charset=utf-8");
	        //创建多重的消息
	        Multipart multipart = new MimeMultipart();
	        //设置文本消息的部分
	        multipart.addBodyPart(messageBodyPart);
	        //添加附件部分
	        messageBodyPart = new MimeBodyPart();
	        DataSource source = new FileDataSource(mail_file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(file_name);
	        multipart.addBodyPart(messageBodyPart);
	        
	        //发送完整的消息
	        message.setContent(multipart);
	        
	        //发送消息
	        Transport.send(message);
	        
	           
		} catch (MessagingException mex) {
			// TODO: handle exception
	
		mex.printStackTrace();
	    }
	}

}
