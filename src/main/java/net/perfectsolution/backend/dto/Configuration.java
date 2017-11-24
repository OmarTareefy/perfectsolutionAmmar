package net.perfectsolution.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Configuration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Please enter the Email Username")
	@Column(name = "gmail_sender_mail_username")
	private String gmailSenderMailUsername;
	
	@NotBlank(message = "Please enter the Email Password")
	@Column(name = "gmail_sender_mail_password")
	private String gmailSenderMailPassword;

	@NotBlank(message = "Please enter the Company Email Address")
	@Column(name = "company_mail_address")
	private String companyMailAddress;
	
	@NotBlank(message = "Please enter the Email Subject")
	@Column(name = "email_subject")
	private String emailSubject;

	@NotBlank(message = "Please enter the Email Subject")
	@Column(name = "company_phone")
	private String companyPhone;

	@NotBlank(message = "Please enter the Facebook link")
	@Column(name = "facebook")
	private String facebook;

	@NotBlank(message = "Please enter the Twitter link")
	@Column(name = "twitter")
	private String twitter;

	
	public String getFacebook() {
		return facebook;
	}


	
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}


	
	public String getTwitter() {
		return twitter;
	}


	
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}


	
	public String getLinkedin() {
		return linkedin;
	}


	
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}


	
	public String getYoutube() {
		return youtube;
	}


	
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}


	@NotBlank(message = "Please enter the Linkedin link")
	@Column(name = "linkedin")
	private String linkedin;

	@NotBlank(message = "Please enter the Youtube link")
	@Column(name = "youtube")
	private String youtube;

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getGmailSenderMailUsername() {
		return gmailSenderMailUsername;
	}

	
	public void setGmailSenderMailUsername(String gmailSenderMailUsername) {
		this.gmailSenderMailUsername = gmailSenderMailUsername;
	}

	
	public String getGmailSenderMailPassword() {
		return gmailSenderMailPassword;
	}

	
	public void setGmailSenderMailPassword(String gmailSenderMailPassword) {
		this.gmailSenderMailPassword = gmailSenderMailPassword;
	}

	
	public String getCompanyMailAddress() {
		return companyMailAddress;
	}

	
	public void setCompanyMailAddress(String companyMailAddress) {
		this.companyMailAddress = companyMailAddress;
	}

	
	public String getEmailSubject() {
		return emailSubject;
	}

	
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	
	public String getCompanyPhone() {
		return companyPhone;
	}

	
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	
	
	/*
	 * 

	company_phone NVARCHAR(128),
	 * */
}
