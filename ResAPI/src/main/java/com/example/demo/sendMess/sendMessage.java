package com.example.demo.sendMess;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.controller.Rescontroller;
import com.example.demo.dao.Dao;
import com.example.demo.dao.DaoImp;
import com.example.demo.model.Manager;

@Component
public class sendMessage {
	private static Logger log = LoggerFactory.getLogger(sendMessage.class);
	
	@Autowired
	Dao res = new DaoImp();
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private String port;
	
	public void sendMail(String mail) throws MessagingException, UnsupportedEncodingException {
		final String toEmail = mail;
		final String userSend = "Made in NguyenViet Hoang";
		if(res == null) System.out.println("null");;
		List<Manager> mng = res.getAll();
		//if(mng == null) return ;
		Properties pro = new Properties();
		pro.put("mail.smtp.host", host);
		pro.put("mail.smtp.port", port);
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.enable", true);
		
		Authenticator au = new Authenticator() {
			protected PasswordAuthentication getPassWordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session ss = Session.getInstance(pro,au);
		
		MimeMessage msg = new MimeMessage(ss);
		
		msg.addHeader("Content-type", "text/HTML; charest=UTF-8");
		msg.addHeader("format","flowed");
		msg.addHeader("Content-Transfer-Encoding", "8bit");
		
		msg.setFrom(new InternetAddress(fromEmail, "Thong bao bien dong so du"));
		msg.setReplyTo(InternetAddress.parse(fromEmail, false));
		msg.setSubject(userSend,"UTF-8");
		
		msg.setText(String.valueOf(mng), "UTF-8");
		msg.setSentDate(new Date());
		
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		Transport.send(msg,fromEmail,password);
		System.out.println("Send Email thanh cong");
		
	}
	
	
}
