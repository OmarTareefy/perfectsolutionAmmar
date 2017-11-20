package net.perfectsolution.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.Service;

@Transactional
@Repository("serviceDAO")
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Service service) {
		try{
			sessionFactory.getCurrentSession().persist(service);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Service service) {
		sessionFactory.getCurrentSession().update(service);
		return true;
	}

	@Override
	public boolean delete(Service service) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Service> list() {

		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Service",Service.class)
						.getResultList();
	}

	@Override
	public List<Service> listActiveServices() {
		
		
		String selectActiveServices = "FROM Service WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveServices);
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Service get(int serviceId) {
		
		return sessionFactory.getCurrentSession()
				.get(Service.class, Integer.valueOf(serviceId));
	}

}
