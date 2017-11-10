package net.perfectsolution.backend.daoimpl;

	

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.AboutDAO;
import net.perfectsolution.backend.dto.About;

@Transactional
@Repository("aboutDAO")
public class AboutDAOImpl implements AboutDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public About get(int aboutId) {
		return sessionFactory.getCurrentSession().get(About.class, Integer.valueOf(aboutId));
	}

	@Override
	public boolean updateAbout(About about) {
		sessionFactory.getCurrentSession().update(about);
		return true;
	}
}
