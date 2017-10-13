package net.perfectsolution.backend.daoimpl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.perfectsolution.backend.dao.AboutDAO;
import net.perfectsolution.backend.dto.About;
import net.perfectsolution.backend.dto.Service;

@Transactional
@Repository("aboutDAO")
public class AboutDAOImpl implements AboutDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public About get(int aboutId) {

		Session session = null;
		try {
			try {
				session = sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
				//TODO this output statement must be replaced with logger log statement with debug level.
				System.out.println("No existing session.");
			}
			if (session == null) {
				session = sessionFactory.openSession();
			}
			return session.get(About.class, Integer.valueOf(aboutId));
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean updateAbout(About about) {
		Session session = null;
		try{
			try{
				session = sessionFactory.getCurrentSession();
			}catch(Exception ex){
				System.out.println("No existing session.");
			}
			if (session == null) {
				session = sessionFactory.openSession();
			}
			sessionFactory.getCurrentSession().update(about);
			return true;
		}catch(Exception ex){
			return false;
		} finally{
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	

}
