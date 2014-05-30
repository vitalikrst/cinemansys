package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Movie;

@Repository
public class MovieDAO extends GenericDAOImpl<Movie> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Movie> getAll() {
		List<Movie> result = null;
		TypedQuery<Movie> query = em.createQuery("from Movie", Movie.class);
		result = query.getResultList();
		return result;
	}

}
