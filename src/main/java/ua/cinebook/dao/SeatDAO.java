package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Seat;

@Repository
public class SeatDAO extends GenericDAOImpl<Seat> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public List<Seat> getAll() {
		List<Seat> result = null;
		TypedQuery<Seat> query = em.createQuery("from Seat", Seat.class);
		result = query.getResultList();
		return result;
	}
	
	public List<Seat> getAll(int hallid) {
		List<Seat> result = null;
		TypedQuery<Seat> query = em.createQuery("from Seat s Hall h where s.hall = h and h.id = :hallid", Seat.class);
		query.setParameter("hallid", hallid);
		result = query.getResultList();
		return result;
	}
	

}
