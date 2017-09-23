package net.perfectsolution.backend.dao;

import net.perfectsolution.backend.dto.ContactMessage;

public interface ContactMessageDAO {
	boolean sendContactMessage(ContactMessage contactMessage);
}
