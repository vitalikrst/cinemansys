package ua.cinebook.web;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import ua.cinebook.entity.Employee;
import ua.cinebook.entity.Hall;
import ua.cinebook.service.AdministratorService;

@Named("administrator")
@Scope("session")
public class AdministratorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AdministratorService aservice;

	List<Hall> hallsList;
	List<Employee> userList;
	String hallName;
	int hallRowsCount;

	public List<Employee> getUserList() {
		return userList;
	}

	public void setUserList(List<Employee> userList) {
		this.userList = userList;
	}

	public String addHall() {
		return null;

	}

	public List<Hall> getHallsList() {
		return hallsList;
	}

	public void setHallsList(List<Hall> hallsList) {
		this.hallsList = hallsList;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public int getHallRowsCount() {
		return hallRowsCount;
	}

	public void setHallRowsCount(int hallRowsCount) {
		this.hallRowsCount = hallRowsCount;
	}

	public AdministratorBean() {
		super();
	}

}
