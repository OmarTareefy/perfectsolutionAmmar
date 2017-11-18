package net.perfectsolution.backend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.ConfigurationDAO;
import net.perfectsolution.backend.dto.Configuration;


@Transactional
@Repository("configurationDAO")
public class ConfigurationDAOImpl implements ConfigurationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Configuration get(int id) {
		return sessionFactory.getCurrentSession().get(Configuration.class, Integer.valueOf(id));
	}

	@Override
	public boolean update(Configuration configuration) {
		sessionFactory.getCurrentSession().update(configuration);
		return true;
	}

}
