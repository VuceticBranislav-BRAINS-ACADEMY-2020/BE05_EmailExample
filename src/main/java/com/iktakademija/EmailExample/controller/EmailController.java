package com.iktakademija.EmailExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktakademija.EmailExample.dto.EmailObject;
import com.iktakademija.EmailExample.services.EmailService;

@RestController
@RequestMapping(path = "/")
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping(method = RequestMethod.POST, path = "/simpleEmail")
	public String sendSimpleEmailMessage(@RequestBody EmailObject emailObject) {
		// check if email object empty
		if (emailObject == null || emailObject.getTo() == null || emailObject.getText() == null) {
			// if null return null
			return null;
		}

		// if not send email via email service
		emailService.sendSimpleMessage(emailObject);

		return "Your email has been send!";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/templateEmail")
	public String sendTemplateMessage(@RequestBody EmailObject object) throws Exception {
		if (object == null || object.getTo() == null || object.getText() == null) {
			return null;
		}
		emailService.sendTemplateMessage(object);
		return "Your mail has been sent! - templateEmail";
	}	

	@RequestMapping(method = RequestMethod.POST, value = "/emailWithAttachment")
	public String sendMessageWithAttachment(@RequestBody EmailObject object) throws Exception {
		if (object == null || object.getTo() == null || object.getText() == null) {
			return null;
		}
		emailService.sendMessageWithAttachment(object, "Attachment.txt");
		// TODO Fix file path to correct location and remove dummy
		return "Your mail has been sent!";		
	}	
	
	// Ovi zadatci su prebaceni na data access projekat.
	
	//  1.1 omogućiti upload fajla sa listom korisnika gde svaki red u fajlu 
	//  sadrži podatke za jednog korisnika (ime i email), gde su podaci delimitirani zarezom
		
	//	1.2 nakon što je fajl sa korisnicima upload-ovan omogućiti čuvanje
	//	svih korisnika koji se nalaze u fajlu
		
	//	1.3 Prilikom dodavanja novog korisnika ili izmene postojećeg korisnika omogućiti proveru 
	//  da li je prosleđena mail adresa korisnika već uneta u bazu podataka. Ukoliko jeste 
	//  zabraniti unos ili izmenu
		
	//	1.4 u klasu UserEntity dodati polje troškovi. Prilikom unosa novog ili izmene postojećeg 
	//  korisnika polje troškovi postaviti na vrednost 5000 ukoliko korisnik živi u Novom Sadu, 
	//  ili 10000 ukoliko korisnik živi u Beogradu. U svim ostalim situacijama upisati vrednost 0 
	//  u polje troškovi

}
