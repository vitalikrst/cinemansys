package ua.cinebook.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import ua.cinebook.dao.ReservationDAO;

@Named
public class ManagerService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	ReservationDAO reservationDAO;

}
