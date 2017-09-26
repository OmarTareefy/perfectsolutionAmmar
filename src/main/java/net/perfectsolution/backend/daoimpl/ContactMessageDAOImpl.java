package net.perfectsolution.backend.daoimpl;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Repository;

import net.perfectsolution.backend.dao.ContactMessageDAO;
import net.perfectsolution.backend.dto.ContactMessage;

@Configuration
@PropertySource("/WEB-INF/props/config.properties")
@Repository("contactMessageDAO")
public class ContactMessageDAOImpl implements ContactMessageDAO {
	
	@Value("${gmailSenderMailUsername}") private String USER_NAME; // GMail user name
	@Value("${gmailSenderMailPassword}") private String PASSWORD; // GMail password
	@Value("${recipientMailAddress}") private String RECIPIENT;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public boolean sendContactMessage(ContactMessage contactMessage) {	
		String from = USER_NAME;
		String pass = PASSWORD;
		String to = RECIPIENT;
		String subject = "Java send mail example";
		String body = contactMessage.getMessage();
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
			System.out.println(message.getEncoding());
			message.setFrom(new InternetAddress(from));
			InternetAddress toAddress = new InternetAddress(to);
			message.setContent("<h1> Omar </h1>", "text/html; charset=utf-8");
			message.addRecipient(Message.RecipientType.TO, toAddress);
			message.setSubject(subject, "UTF-8");
			message.setText(body, "UTF-8");
			//message.setContentLanguage(new String[]{"ar"});
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
