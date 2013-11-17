package com.williansmartins.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.williansmartins.model.Usuario;

//@NamedQuery(name="UsuarioDaoImpl.findEntity", query="SELECT p FROM Usuario p WHERE p.usuario = :user and p.senha = :pass ")
public class UsuarioDaoImpl extends JpaGenericDao<Usuario> implements IUsuarioDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	List<Usuario> lista;
	
	public UsuarioDaoImpl() {
		emf = Persistence.createEntityManagerFactory("manager-mysql");
		entityManager = getEntityManager();
	}
	
	public Usuario findUser(String u, String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Usuario p WHERE p.usuario = '" + u + "' and p.senha = '" + s + "'";
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
	
	public List<Usuario> findEspecific(String s) {
		entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		
		String jpql = "SELECT p FROM Usuario p WHERE p.nome like '%" + s + "%'";
		Query query = entityManager.createQuery(jpql);
		lista = (List<Usuario>)query.getResultList();
		
		
		entityManager.flush();
		
		entityManager.close();
		if(lista.size() > 0){
			return lista;
		}else{
			return null;
		}
	}
}

