package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Operation;

@Repository
public class OperationDAO extends GenericDAOImpl<Operation> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Operation> getAll() {
		List<Operation> result = null;
		TypedQuery<Operation> query = em.createQuery("from Operation", Operation.class);
		result = query.getResultList();
		return result;
	}

}
