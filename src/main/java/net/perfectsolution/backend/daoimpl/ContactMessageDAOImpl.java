package net.perfectsolution.backend.daoimpl;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Repository;

import net.perfectsolution.backend.dao.ContactMessageDAO;
import net.perfectsolution.backend.dto.ContactMessage;
import net.perfectsolution.backend.utils.Utilities;

@Configuration
@PropertySource("/WEB-INF/props/config.properties")
@Repository("contactMessageDAO")
public class ContactMessageDAOImpl implements ContactMessageDAO {
	
	@Value("${gmailSenderMailUsername}") private String USER_NAME; // GMail user name
	@Value("${gmailSenderMailPassword}") private String PASSWORD; // GMail password
	@Value("${companyMailAddress}") private String RECIPIENT;
	@Value("${emailSubject}") private String SUBJECT;
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public boolean sendContactMessage(ContactMessage contactMessage) {	
		String from = USER_NAME;
		String pass = PASSWORD;
		String to = RECIPIENT;
		String subject = SUBJECT ;
		String htmlBody = buildEmailBody(contactMessage);
		return Utilities.sendFromGMail(from, pass, to, subject, htmlBody);
	}
	
	private static String buildEmailBody(ContactMessage contactMessage){
		StringBuilder htmlBody = new StringBuilder();
		htmlBody.append("<h2>The following message was sent from " + contactMessage.getFullName() +"<h2></br>");
		htmlBody.append("<h4>Message Subject: "+ contactMessage.getSubject() + "</h4></br>");
		htmlBody.append("</br><p>\""+ contactMessage.getMessage() + "\"</p></br>");
		htmlBody.append("<h4>Email Address: "+ contactMessage.getEmailAddress() + "</h4></br>");
		if(contactMessage.getPhone() != null && !contactMessage.getPhone().isEmpty()){
			htmlBody.append("<h4>Phone: "+ contactMessage.getPhone() + "</h4></br>");
		}
		return htmlBody.toString();
	}
}
