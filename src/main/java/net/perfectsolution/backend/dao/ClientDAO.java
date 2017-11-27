package net.perfectsolution.backend.dao;

import java.util.List;

import net.perfectsolution.backend.dto.Client;

public interface ClientDAO {
	
	Client get(int id);
	boolean add (Client client);
	boolean update(Client client);
	
	List<Client> list();
	List<Client> listActiveClients();
}
