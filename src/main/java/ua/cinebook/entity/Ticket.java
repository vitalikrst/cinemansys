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
@Table(name = "Tickets")
public class Ticket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// @Column(name = "Reservation_id")
	// private int reservationId;
	//
	// @Column(name = "Session_id")
	// private int sessionId;

	private int status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Reservation_id")
	private Reservation reservation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Session_id")
	private Session session;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public int getReservationId() {
	// return reservationId;
	// }
	//
	// public void setReservationId(int reservationId) {
	// this.reservationId = reservationId;
	// }
	//
	// public int getSessionId() {
	// return sessionId;
	// }
	//
	// public void setSessionId(int sessionId) {
	// this.sessionId = sessionId;
	// }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Ticket() {
		super();
	}

	public Ticket(int status, Session session) {
		super();
		this.status = status;
		this.session = session;
	}

}
