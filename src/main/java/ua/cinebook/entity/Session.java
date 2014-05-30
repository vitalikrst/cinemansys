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
@Table(name = "Sessions")
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private int status;

	// @Column(name = "Hall_id")
	// private int hallId;
	//
	// @Column(name = "Movie_id")
	// private int movieId;

	private double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Hall_id")
	private Hall hall;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Movie_id")
	private Movie movie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// public int getHallId() {
	// return hallId;
	// }
	//
	// public void setHallId(int hallId) {
	// this.hallId = hallId;
	// }
	//
	// public int getMovieId() {
	// return movieId;
	// }
	//
	// public void setMovieId(int movieId) {
	// this.movieId = movieId;
	// }

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Session() {
		super();
	}

	public Session(Date date, int status, double price, Hall hall, Movie movie) {
		super();
		this.date = date;
		this.status = status;
		this.price = price;
		this.hall = hall;
		this.movie = movie;
	}

}
