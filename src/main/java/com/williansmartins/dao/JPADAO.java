package com.williansmartins.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.williansmartins.model.PedidoEntity;

public class JPADAO{

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	List<PedidoEntity> lista;
	
	public JPADAO() {
		emf = Persistence.createEntityManagerFactory("manager-mysql");
		entityManager = getEntityManager();
	}
	
	public PedidoEntity insert(PedidoEntity entity) {
		entityManager = getEntityManager();
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("ERRO: " + e.getMessage());
		}finally{
			entityManager.close();
		}
		return entity;
	}

	public PedidoEntity findById(PedidoEntity entity) {
		entityManager = getEntityManager();
		try {
			entity = entityManager.find(PedidoEntity.class, entity.getId());
		    return entity;
		}catch (Exception e) {
			System.out.println(">> "+e.getMessage());
			return null;
		}finally {
		    entityManager.close();
		}
	}
	
	public PedidoEntity delete(PedidoEntity entity) {
		entityManager = getEntityManager();
		try{
			entity = entityManager.find(PedidoEntity.class, entity.getId());
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(">> "+e.getMessage());
		}
		finally {
			entityManager.close();
	    }
		return entity;
	}
	public List<PedidoEntity> findAll() {
		entityManager = getEntityManager();		
		Query query = entityManager.createQuery("SELECT e FROM pedido_jpa e");
		List<PedidoEntity> lista = query.getResultList();
	    entityManager.close();
		return lista;
	}
	
//	public List<PedidoEntity> findEspecific(Long id) {
//		entityManager = getEntityManager();	
//		entityManager.getTransaction().begin();
//		String jpql = "select a from Avaliacao a";
//																			
//		Query query = entityManager.createQuery(jpql);
//		lista = query.getResultList();
//		System.out.println("BUSCANDO :" + id);
//		entityManager.getTransaction().commit();
//		if(lista.size() > 0){
//			entityManager.close();
//			return lista;
//		}else{
//			entityManager.close();
//			return null;
//		}
//	}
	


//    public void update(PedidoEntity entity) {
//		entityManager = getEntityManager();
//		try {
//			entityManager.getTransaction().begin();
//			entityManager.merge(entity);
//			entityManager.getTransaction().commit();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			entityManager.getTransaction().rollback();
//		} finally {
//			entityManager.close();
//		}
//    }
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		if(entityManager == null || !(entityManager.isOpen())){
			return emf.createEntityManager();
		}
		return entityManager;
	}
//	public  Boolean verificaUsuario(String valor){
//		entityManager = getEntityManager();	
//		entityManager.getTransaction().begin();
//		String jpql = "select a from Usuario a where a.usuario= :valorx";
//																			
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter("valorx", valor);
//
//		entityManager.getTransaction().commit();
//		lista = query.getResultList();
//		
//		if(lista.size() > 0){
//			return true;
//		}else{
//			return false;
//		}
//	}
}
