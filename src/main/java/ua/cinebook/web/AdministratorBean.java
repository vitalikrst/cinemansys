package ua.cinebook.web;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import ua.cinebook.service.AdministratorService;

@Named("administrator")
@Scope("session")
public class AdministratorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	AdministratorService aservice;

	String hallName;
	int hallRowsCount;
	
	public String addHall(){
		return null;
		
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
