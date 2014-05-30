package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Reservation;

@Repository
public class ReservationDAO extends GenericDAOImpl<Reservation> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Reservation> getAll() {
		List<Reservation> result = null;
		TypedQuery<Reservation> query = em.createQuery("from Reservation", Reservation.class);
		result = query.getResultList();
		return result;
	}

}
