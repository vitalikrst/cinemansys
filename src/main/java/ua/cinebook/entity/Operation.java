package ua.cinebook.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Operations")
public class Operation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int operationType;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	// @Column(name = "Employee_id")
	// private int employeeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Employee_id")
	private Employee employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOperationType() {
		return operationType;
	}

	public void setOperationType(int operationType) {
		this.operationType = operationType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	// public int getEmployeeId() {
	// return employeeId;
	// }
	//
	// public void setEmployeeId(int employeeId) {
	// this.employeeId = employeeId;
	// }

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Operation() {
		super();
	}

	public Operation(int operationType, Date date, Employee employee) {
		super();
		this.operationType = operationType;
		this.date = date;
		this.employee = employee;
	}

}
