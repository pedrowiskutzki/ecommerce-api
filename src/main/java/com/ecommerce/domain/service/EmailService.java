package com.ecommerce.domain.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ecommerce.domain.model.MensagemEmail;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviar(MensagemEmail mensagemEmail)  {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		
		try {
			helper.setFrom(mensagemEmail.getRemetente());
			helper.setSubject(mensagemEmail.getAssunto());
			helper.setText(mensagemEmail.getMensagem(), true);
			
			// Transformo a minha lista de string emum array de string.
			helper.setTo(mensagemEmail.getDestinatarios()
					.toArray(new String[mensagemEmail.getDestinatarios().size()]));
			
			//Aqui acontece o envio.
			javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
}
