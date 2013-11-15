package com.williansmartins.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.model.PedidoEntity;

//@NamedQuery(name="UsuarioDaoImpl.findEntity", query="SELECT p FROM Usuario p WHERE p.usuario = :user and p.senha = :pass ")
public class PedidoDaoImpl extends JpaGenericDao<PedidoEntity> implements IPedidoDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	List<PedidoEntity> lista;
	
	public PedidoDaoImpl() {
		emf = Persistence.createEntityManagerFactory("manager-mysql");
		entityManager = getEntityManager();
	}
	
	public PedidoEntity findUser(String u, String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Pedido p WHERE p.usuario = '" + u + "' and p.senha = '" + s + "'";
		Query query = entityManager.createQuery(jpql);
		lista = query.getResultList();

		
		entityManager.flush();
		
		entityManager.close();
		if(lista.size() > 0){
			return lista.get(0);
		}else{
			return null;
		}
	}
	
	public List<PedidoEntity> findEspecific(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Pedidop WHERE p.nome like '%" + s + "%'";
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

