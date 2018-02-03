package net.perfectsolution.backend.dao;

import javax.servlet.http.HttpServletRequest;

import net.perfectsolution.backend.dto.ContactMessage;

public interface ContactMessageDAO {
	boolean sendContactMessage(ContactMessage contactMessage, HttpServletRequest request);
}
