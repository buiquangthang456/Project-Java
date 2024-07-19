package com.vanlang.service;

import com.vanlang.entity.Mailer;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface MailerService {

	void send(Mailer mail) throws MessagingException;

	void send(String to, String subject, String body) throws MessagingException;

	void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException;

}
