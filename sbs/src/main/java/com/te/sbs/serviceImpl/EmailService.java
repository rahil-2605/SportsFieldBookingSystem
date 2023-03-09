package com.te.sbs.serviceImpl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
	
	private final JavaMailSender mailSender; 
	
	public void sendEmail(String toEmail,String subject,String body) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("rahilahmed440@gmail.com");
		message.setText(body);
		message.setSubject(subject);
		message.setTo(toEmail);
		
		mailSender.send(message);
		
		System.out.println("Mail Sent successfully");
		
	}
	

}
