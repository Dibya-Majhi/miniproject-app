package com.example.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.hibernate.pretty.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.service.ReportService;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender MailSender;
	
	//here file come from pdf (file f)for attachment 
	public boolean sendEmail(String subject,String body,String to,File f) {
		
		try {
			//we can send attachment (html)to email thats why mimemesage created
			MimeMessage mimeMswg = MailSender.createMimeMessage();
			
			//create helper class using mimeMessage
			MimeMessageHelper helper=new MimeMessageHelper(mimeMswg,true);
			
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.setTo(to);
			//want to send attachment and send to email
			helper.addAttachment("file info", f);//i want to pass the file object in impl class
			
			MailSender.send(mimeMswg);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return true;
	}

}
