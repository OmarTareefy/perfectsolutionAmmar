package net.perfectsolution.backend.dao;

import java.util.List;

import net.perfectsolution.backend.dto.Subscriber;

public interface SubscriberDAO {

	boolean add (Subscriber subscriber);
	boolean update (Subscriber subscriber);
	
	List<Subscriber> list();
	List<Subscriber> listActiveSubscribers();
	String getSubscribersAsCSV();

}
