package org.narainfo.tool;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailAuth extends Authenticator {

	PasswordAuthentication pa;
	
	public EmailAuth() {
		pa = new PasswordAuthentication("aidocu.backup@gmail.com", "00dmlwjr"); 
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
