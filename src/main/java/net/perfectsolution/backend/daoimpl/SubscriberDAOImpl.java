package net.perfectsolution.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.SubscriberDAO;
import net.perfectsolution.backend.dto.Subscriber;

@Transactional
@Repository("subscriberDAO")
public class SubscriberDAOImpl implements SubscriberDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean add(Subscriber subscriber) {
		try{
			sessionFactory.getCurrentSession().persist(subscriber);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Subscriber subscriber) {
		sessionFactory.getCurrentSession().update(subscriber);
		return true;
	}

	@Override
	public List<Subscriber> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Subscriber",Subscriber.class)
						.getResultList();
	}

	@Override
	public List<Subscriber> listActiveSubscribers() {
		String selectActiveSubscribers = "FROM Subscriber WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSubscribers);
		query.setParameter("active", true);
		return query.getResultList();
	}

}
