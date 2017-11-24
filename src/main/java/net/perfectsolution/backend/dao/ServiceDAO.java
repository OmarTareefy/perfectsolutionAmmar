package net.perfectsolution.backend.dao;
import java.util.List;

import net.perfectsolution.backend.dto.Service;

public interface ServiceDAO {

	Service get(int id);
	boolean add (Service service);
	boolean update (Service service);

	List<Service> listCategoryActiveServices(int categoryId);
	List<Service> listCategoryServices(int categoryId);
	
	List<Service> list();
}
