package bw.practise.ang.util;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;


public class sendEmailMethod {
	private static String MAIL_ADDRESS = "827021353@qq.com";
	private static String MAIL_USERNAME = "827021353@qq.com";
	private static String MAIL_PASSWORD = "glvwewqqdgerbbga";
	private static String MAIL_SERVER = "smtp.qq.com";
	
	public static void sendMailFilter(String mail_address,String mail_title,String mail_file,String mail_content,String file_name) {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = new Properties();
		// 存储发送邮件服务器的信息
		pro.put("mail.smtp.host", MAIL_SERVER);
		// 同时通过验证
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.port", "465");
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
		// 根据属性新建一个邮件会话
		Session s = Session.getInstance(pro);
		// 打印一些调试信息。
		s.setDebug(true); 
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session
				.getDefaultInstance(pro, authenticator);
		
	/*	String nick=" ";
		try {
			nick=javax.mail.internet.MimeUtility.encodeText(name);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress("827021353@qq.com");
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中
			Address to = new InternetAddress(mail_address);
			// Message.RecipientType.TO属性表示接收者的类型为TO
			mailMessage.setRecipient(Message.RecipientType.TO, to);
			// 设置邮件消息的主题
			mailMessage.setSubject(mail_title);
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart multipart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			BodyPart messageBodyPart = new MimeBodyPart();
			// 设置HTML内容
			messageBodyPart.setContent(mail_content, "text/html; charset=utf-8");
			messageBodyPart = new MimeBodyPart();
			//添加附件
		    FileDataSource source = new FileDataSource(mail_file);
		    messageBodyPart.setDataHandler(new DataHandler(source));
		    messageBodyPart.setFileName(file_name);
		        
		    multipart.addBodyPart(messageBodyPart);
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(multipart);
			// 发送邮件
			Transport.send(mailMessage);
		} catch (MessagingException ex) {
			 System.err.println("增加邮件附件：" + file_name + "发生错误！" + ex);
		}
		
	}

}
