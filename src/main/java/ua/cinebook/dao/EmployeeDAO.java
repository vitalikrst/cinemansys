package ua.cinebook.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ua.cinebook.entity.Employee;


@Repository
public class EmployeeDAO extends GenericDAOImpl<Employee> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Employee> getAll() {
		List<Employee> result = null;
		TypedQuery<Employee> query = em.createQuery("from Employee", Employee.class);
		result = query.getResultList();
		return result;
	}

}
