package ua.cinebook.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import ua.cinebook.dao.MovieDAO;
import ua.cinebook.entity.Movie;

@Named
public class ContentManagerService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	MovieDAO movieDAO;
	
	@Transactional
	public void addNewMovie(String name, String description, String imageLink) {
		movieDAO.create(new Movie(name, description, imageLink));
	}
	
	@Transactional
	public void addNewSession() {
		
	}
	
	@Transactional
	public void updateSession() {
		
	}
	
	@Transactional
	public void updateMovie(Movie m) {
		movieDAO.update(m);
	}
	
	
	
	

}
