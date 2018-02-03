package net.perfectsolution.backend.daoimpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.perfectsolution.backend.dao.ConfigurationDAO;
import net.perfectsolution.backend.dao.ContactMessageDAO;
import net.perfectsolution.backend.dto.Configuration;
import net.perfectsolution.backend.dto.ContactMessage;
import net.perfectsolution.backend.utils.Utilities;

//@Configuration
//@PropertySource("/WEB-INF/props/config.properties")
@Repository("contactMessageDAO")
public class ContactMessageDAOImpl implements ContactMessageDAO {
/*	
	@Value("${gmailSenderMailUsername}") private String USER_NAME; // GMail user name
	@Value("${gmailSenderMailPassword}") private String PASSWORD; // GMail password
	@Value("${companyMailAddress}") private String RECIPIENT;
	@Value("${emailSubject}") private String SUBJECT;
*/	
	@Autowired
	ConfigurationDAO configurationDAO;
/*	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
*/
	@Override
	public boolean sendContactMessage(ContactMessage contactMessage, HttpServletRequest request) {
		Configuration configuration = configurationDAO.get(1);
		String from = configuration.getGmailSenderMailUsername();
		String pass = configuration.getGmailSenderMailPassword();
		String to = configuration.getCompanyMailAddress();
		String subject = configuration.getEmailSubject() ;
		String htmlBody = buildEmailBody(contactMessage, request);
		return Utilities.sendFromGMail(from, pass, to, subject, htmlBody);
	}
	/*
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
	}*/
	
	private static String buildEmailBody(ContactMessage contactMessage, HttpServletRequest request){
		StringBuilder htmlBody = new StringBuilder();
		
		try {
			BufferedReader in = new BufferedReader(
								new FileReader(request.getSession().getServletContext().getRealPath("/WEB-INF/htmlTemplates/clientEmail.html")));
		    String str;
		    while ((str = in.readLine()) != null) {
		    	htmlBody.append(str);
		    }
		    in.close();
		} catch (IOException e) {
		}
		
		String htmlBodyAsString = htmlBody.toString()
						.replace("(clientfullName)", contactMessage.getFullName())
						.replace("(clientSubject)", contactMessage.getSubject())
						.replace("(clientMessage)", contactMessage.getMessage())
						.replace("(clientEmail)", contactMessage.getEmailAddress())
						.replace("(clientPhone)", contactMessage.getPhone());
		
		return htmlBodyAsString;
	}
}
