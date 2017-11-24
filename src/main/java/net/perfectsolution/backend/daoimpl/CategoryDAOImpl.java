package net.perfectsolution.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.CategoryDAO;
import net.perfectsolution.backend.dto.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession()
				.get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try{
			sessionFactory.getCurrentSession().update(category);
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Category> list(int categoryType) {
		String selectCategories = "FROM Category WHERE categoryType = :categoryType";
		Query query = sessionFactory.getCurrentSession().createQuery(selectCategories);
		query.setParameter("categoryType", categoryType);
		return query.getResultList();
	}

	@Override
	public List<Category> listActiveCategories(int categoryType) {
		String selectActiveCategories = "FROM Category WHERE categoryType = :categoryType AND active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories);
		query.setParameter("active", true);
		query.setParameter("categoryType", categoryType);
		return query.getResultList();
	}

}
