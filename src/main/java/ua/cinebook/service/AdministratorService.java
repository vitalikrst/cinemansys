package ua.cinebook.service;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import ua.cinebook.dao.EmployeeDAO;
import ua.cinebook.dao.HallDAO;
import ua.cinebook.dao.SeatDAO;
import ua.cinebook.entity.Employee;
import ua.cinebook.entity.Hall;

@Named
public class AdministratorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	HallDAO hallDAO;
	@Inject
	SeatDAO seatDAO;
	@Inject
	EmployeeDAO employeeDAO;
	
	@Transactional
	public void addNewHall(String name) {

	}
	
	@Transactional
	public void changeHallName(Hall h) {
		hallDAO.update(h);
	}
	
	@Transactional
	public void addNewEmployee(String name, String group, String password) {
		String passhash = getHash(password);
		Employee e = new Employee(name, group, passhash);
		employeeDAO.create(e);
	}
	
	@Transactional
	public void updateEmployee(Employee e) {
		employeeDAO.update(e);
	}
	
	
//	@Transactional
//	public void setTimeLeft() {
//		
//	}
//	
//	@Transactional
//	public void setCinemaName() {
//		
//	}
	
	
	/*
	 * Generate MD5 Hash
	 */
	public static String getHash(String input) {
		String md5 = null;
		if (null == input)
			return null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}
	

}
