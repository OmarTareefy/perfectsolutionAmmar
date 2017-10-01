package net.perfectsolution.backend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.perfectsolution.backend.dao.ServiceDAO;
import net.perfectsolution.backend.dto.Service;

@Transactional
@Repository("serviceDAO")
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Service service) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Service service) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Service service) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Service> list() {

		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Service", Service.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Service> listActiveServices() {

		String selectActiveServices = "FROM Service WHERE isActive = :isActive";
		
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}
		
		try {
			Query query = session.createQuery(selectActiveServices, Service.class);
			query.setParameter("isActive", true);
			return query.getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Service get(int serviceId) {
		
		Session session;

		try {
		    session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
		    session = sessionFactory.openSession();
		}

		return session.get(Service.class, Integer.valueOf(serviceId));
	}

}
