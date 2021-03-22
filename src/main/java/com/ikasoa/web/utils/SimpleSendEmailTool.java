package com.ikasoa.web.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

@AllArgsConstructor
public class SimpleSendEmailTool {

	private String from = null;
	private String password = null;
	private SmtpServerEnum smtpServer = null;
	
	@SneakyThrows
	public void send(String mail, String title, String text) {
		Properties props = new Properties();
		props.setProperty("mail.host", smtpServer.getHost());
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.port", smtpServer.getPort());
		props.setProperty("mail.smtp.port", smtpServer.getPort());
//		props.setProperty("mail.smtp.ssl.enable", "true");
		send(mail, title, text, props);
	}

	@SneakyThrows
	public void send(String mail, String title, String text, Properties props) {
		Session session = Session.getInstance(props);
		session.setDebug(true);
		Transport ts = session.getTransport();
		ts.connect(smtpServer.getHost(), from, password);
		Message message = createSimpleMail(session, from, mail, title, text);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	private MimeMessage createSimpleMail(Session session, String mailfrom, String mailTo, String mailTittle,
			String mailText) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mailfrom));
        message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(mailTo));
//		message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
		message.setSubject(mailTittle);
		message.setContent(mailText, "text/html;charset=UTF-8");
		return message;
	}

	@AllArgsConstructor
	public enum SmtpServerEnum {

		EXMAIL_QQ("smtp.exmail.qq.com", "465"), GMAIL("smtp.gmail.com", "465");

		@Getter
		private String host;
		@Getter
		private String port;

	}

}
