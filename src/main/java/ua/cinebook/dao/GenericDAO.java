package ua.cinebook.dao;

/*
 * Generic interface for CRUD operations
 */
public interface GenericDAO<T> {
	T create(T t);
	void delete(Object id);
	T find(Object id);
	T update(T t);
}
