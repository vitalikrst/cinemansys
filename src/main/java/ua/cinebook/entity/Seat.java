package ua.cinebook.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Seats")
public class Seat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int row;
	private int seat;

	// @Column(name = "Hall_id")
	// private int hallId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Hall_id")
	private Hall hall;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	// public int getHallId() {
	// return hallId;
	// }
	//
	// public void setHallId(int hallId) {
	// this.hallId = hallId;
	// }

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Seat(int row, int seat, Hall hall) {
		super();
		this.row = row;
		this.seat = seat;
		this.hall = hall;
	}

	public Seat() {
		super();
	}

}
