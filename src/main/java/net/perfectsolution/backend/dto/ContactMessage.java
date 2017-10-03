package net.perfectsolution.backend.dto;

import org.hibernate.validator.constraints.NotBlank;

public class ContactMessage {

	@NotBlank(message="error!")
	private String fullName;
	private String emailAddress;
	private String phone;
	private String subject;
	private String message;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ContactMessage [fullName=" + fullName + ", emailAddress=" + emailAddress + ", phone=" + phone
				+ ", subject=" + subject + ", message=" + message + "]";
	}
	
}
