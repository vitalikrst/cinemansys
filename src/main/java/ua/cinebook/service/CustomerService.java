package ua.cinebook.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import ua.cinebook.dao.ReservationDAO;

@Named
public class CustomerService implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	ReservationDAO reservationDAO;
	
	@Transactional
	public int addOrder() {
		
		
		return 0;
	}


}
