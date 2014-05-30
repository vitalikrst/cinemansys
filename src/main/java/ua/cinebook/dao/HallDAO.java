package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Hall;

@Repository
public class HallDAO extends GenericDAOImpl<Hall> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Hall> getAll() {
		List<Hall> result = null;
		TypedQuery<Hall> query = em.createQuery("from Hall", Hall.class);
		result = query.getResultList();
		return result;
	}
	
	
}
