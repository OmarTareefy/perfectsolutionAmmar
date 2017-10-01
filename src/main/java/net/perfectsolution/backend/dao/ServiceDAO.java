package net.perfectsolution.backend.dao;
import java.util.List;

import net.perfectsolution.backend.dto.Service;

public interface ServiceDAO {

	Service get(int id);
	boolean add (Service service);
	boolean update (Service service);
	boolean delete (Service service);

	List<Service> list();
	List<Service> listActiveServices();
}
