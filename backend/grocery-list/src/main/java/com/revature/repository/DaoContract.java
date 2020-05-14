package com.revature.repository;

import java.util.List;


public interface DaoContract<T, I> {
	
	T findById(I i);
	
	void save(T t);

	boolean delete(T t);

	T update(T t);

	List<T> findAll();

	List<T> findAllById(int id);

	T findByString(String s);

}