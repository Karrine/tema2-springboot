package com.unitbv.labs.tema2springboot.interfaces;

public interface GenericDAO<T> {

	public void close();

	public void createOrUpdate(T entity);

	public T findById(int id);

	public T update(T entity);

	public void delete(T entity);


}
