package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Ticket;

@Repository
public class TicketDAO extends GenericDAOImpl<Ticket> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Ticket> getAll() {
		List<Ticket> result = null;
		TypedQuery<Ticket> query = em.createQuery("from Ticket", Ticket.class);
		result = query.getResultList();
		return result;
	}

}
