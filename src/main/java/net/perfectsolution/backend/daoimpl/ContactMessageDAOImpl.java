package net.perfectsolution.backend.daoimpl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import net.perfectsolution.backend.dao.ContactMessageDAO;
import net.perfectsolution.backend.dto.ContactMessage;

@Configuration
@ComponentScan(basePackages = "net.perfectsolution")
@PropertySource(value="/WEB-INF/props/config.properties")
public class ContactMessageDAOImpl implements ContactMessageDAO {

	/*
	private static String USER_NAME = "Mashagbawebsite"; // GMail user name
	private static String PASSWORD = "mashagbawebsite2017"; // GMail password
	private static String RECIPIENT = "omar.tareefy@hotmail.com";
*/
	@Value("${gmailSenderMailUsername}")
	private static String USER_NAME; // GMail user name
	@Value("${gmailSenderMailPassword}")
	private static String PASSWORD; // GMail password
	@Value("${recipientMailAddress")
	private static String RECIPIENT;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Override
	public boolean sendContactMessage(ContactMessage contactMessage) {

		String from = USER_NAME;
		String pass = PASSWORD;
		String to = RECIPIENT; // list of recipient email addresses
		String subject = "Java send mail example";
		String body = "Welcome to JavaMail!";

		return sendFromGMail(from, pass, to, subject, body);
	}

	private static boolean sendFromGMail(String from, String pass, String to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress toAddress = new InternetAddress(to);
			message.addRecipient(Message.RecipientType.TO, toAddress);
			
			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
			return false;
		} catch (MessagingException me) {
			me.printStackTrace();
			return false;
		}
		return true;
	}

}
