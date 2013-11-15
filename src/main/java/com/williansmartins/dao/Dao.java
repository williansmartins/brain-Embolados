package com.williansmartins.dao;

import java.io.Serializable;
import java.util.List;

import com.williansmartins.model.PedidoEntity;

public interface Dao<T extends Serializable> {

	PedidoEntity insert(T entity);
	void update(T entity);
	void delete(Long primaryKey) throws Exception;
	List<T> findAll();
	List<T> findEspecific(Long id);
	T findById(Long primaryKey);
	
}
