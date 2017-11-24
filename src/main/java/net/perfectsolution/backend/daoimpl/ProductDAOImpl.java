package net.perfectsolution.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.ProductDAO;
import net.perfectsolution.backend.dto.Product;
import net.perfectsolution.backend.dto.Service;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession()
				.get(Product.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Product product) {
		try{
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try{
			sessionFactory.getCurrentSession().update(product);
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product",Product.class)
						.getResultList();
	}

	@Override
	public List<Product> listCategoryActiveProducts(int categoryId) {
		String selectCategoryActiveProducts = "FROM Product WHERE active = :active and categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(selectCategoryActiveProducts);
		query.setParameter("active", true);
		query.setParameter("categoryId", categoryId);
		
		return query.getResultList();
	}

	@Override
	public List<Product> listCategoryProducts(int categoryId) {
		String selectCategoryProducts = "FROM Product WHERE categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(selectCategoryProducts);
		query.setParameter("categoryId", categoryId);
		
		return query.getResultList();
	}

}
