package net.perfectsolution.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.perfectsolution.backend.dao.ClientDAO;
import net.perfectsolution.backend.dto.Client;

@Transactional
@Repository("clientDAO")
public class ClientDAOImpl implements ClientDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Client get(int id) {
		return sessionFactory.getCurrentSession()
				.get(Client.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Client client) {
		try{
			sessionFactory.getCurrentSession().persist(client);
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Client client) {
		try{
			sessionFactory.getCurrentSession().update(client);
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Client> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Client",Client.class)
						.getResultList();
	}

	@Override
	public List<Client> listActiveClients() {
		String selectActiveClients = "FROM Client WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveClients);
		query.setParameter("active", true);
		return query.getResultList();
	}

}
