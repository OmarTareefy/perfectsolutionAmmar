package net.perfectsolution.backend.dao;

import java.util.List;

import net.perfectsolution.backend.dto.Category;

public interface CategoryDAO {

	Category get(int id);
	boolean add (Category category);
	boolean update (Category category);

	List<Category> list(int categoryType);
	List<Category> listActiveCategories(int categoryType);

}
