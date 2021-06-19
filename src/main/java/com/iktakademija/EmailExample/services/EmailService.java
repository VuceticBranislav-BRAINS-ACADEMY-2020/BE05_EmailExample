package com.iktakademija.EmailExample.services;

import com.iktakademija.EmailExample.dto.EmailObject;

public interface EmailService {
	
	public void sendSimpleMessage(EmailObject emailObject);
	public void sendTemplateMessage(EmailObject object) throws Exception;
	public void sendMessageWithAttachment(EmailObject object, String pathToAttachment) throws Exception;
	
}
