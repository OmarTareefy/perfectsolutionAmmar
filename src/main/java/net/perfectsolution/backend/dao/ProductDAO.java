package net.perfectsolution.backend.dao;

import java.util.List;

import net.perfectsolution.backend.dto.Product;

public interface ProductDAO {

	Product get(int id);
	boolean add (Product product);
	boolean update (Product product);
	boolean delete (Product product);

	List<Product> list();
	List<Product> listActiveProducts();
}
