package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Session;

@Repository
public class SessionDAO extends GenericDAOImpl<Session> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Session> getAll() {
		List<Session> result = null;
		TypedQuery<Session> query = em.createQuery("from Session", Session.class);
		result = query.getResultList();
		return result;
	}

}
