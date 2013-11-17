package com.williansmartins.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.model.PedidoEntity;

public class PedidoDaoImpl extends JpaGenericDao<PedidoEntity> implements IPedidoDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	List<PedidoEntity> lista;
	
	public PedidoDaoImpl() {
		entityManager = getEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public List<PedidoEntity> findEspecific(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Pedido p WHERE p.nome like '%" + s + "%'";
		Query query = entityManager.createQuery(jpql);
		lista = (List<PedidoEntity>)query.getResultList();
		
		
		entityManager.flush();
		
		entityManager.close();
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}
}

