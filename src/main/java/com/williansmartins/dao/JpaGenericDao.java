package com.williansmartins.dao;


public class JpaGenericDao<T extends Serializable> implements Dao<T>{

	@PersistenceContext
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	List<T> lista;
	
	public JpaGenericDao() {
		emf = Persistence.createEntityManagerFactory("manager-mysql");
		entityManager = getEntityManager();
	}
	
	//METODOS SOBRESCRITOS DE IClienteDao
	 @Override
	public PedidoEntity insert(T entity) {
		entityManager = getEntityManager();
		try{
			//System.out.println("JPA-GENERIC-DAO: insert entity");
			//inicia o processo de transacao
			entityManager.getTransaction().begin();
			//faz a persistencia
			entityManager.persist(entity);
			//manda bala para o BD
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			//se der algo de errado vem parar aqui, onde � cancelado
			entityManager.getTransaction().rollback();
			System.out.println("ERRO: " + e.getMessage());
		}finally{
			entityManager.close();
		}
		return (PedidoEntity) entity;
	}
	
	@Override
	public List<T> findAll() {
		entityManager = getEntityManager();		
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getGenericClass());
		criteriaQuery.from(getGenericClass());
		List<T> lista = entityManager.createQuery(criteriaQuery).getResultList();
		entityManager.close();
		return lista;
	}
	@Override
	
	public List<T> findEspecific(Long id) {
		entityManager = getEntityManager();	
		entityManager.getTransaction().begin();
//		String jpql = "select a.avaliacoes from Usuario a where a.id_usuario= :idx";
		String jpql = "select a from Avaliacao a";
																			
		Query query = entityManager.createQuery(jpql);
//		query.setParameter("idx", id);
		lista = query.getResultList();
		System.out.println("BUSCANDO :" + id);
		entityManager.getTransaction().commit();
		if(lista.size() > 0){
			entityManager.close();
			return lista;
		}else{
			entityManager.close();
			return null;
		}
	}
	@Override
	
	public void delete(Long primaryKey) throws Exception {
		entityManager = getEntityManager();
		try{
//			T entity = (T) entityManager.find(getGenericClass(), Long.parseLong(primaryKey+""));
			T entity = (T) entityManager.find(getGenericClass(), primaryKey);
			//inicia o processo de transacao
			entityManager.getTransaction().begin();
			// Remove a pessoa da base de dados.
			entityManager.remove(entity);
			// Finaliza a transa��o.
			entityManager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(">> "+e.getMessage());
			throw new Exception("\n" + e.getMessage()+ " \n " +e.getCause()+e.getStackTrace());
		}
		finally {
			entityManager.close();
	    }
	}

	@Override
	public T findById(Long primaryKey) {
		entityManager = getEntityManager();
		T entity = null;
		try {
		      //Consulta um Cliente pelo seu ID.
			entity = (T) entityManager.find(getGenericClass(), primaryKey);
		    return entity;
		}catch (Exception e) {
			System.out.println(">> "+e.getMessage());
			return null;
		}finally {
		   // entityManager.close();
		}
	}

	@Override
    public void update(T entity) {
		entityManager = getEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
//			return true; op��o para exibir se foi atualizado com sucesso
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
//			return false;
		} finally {
			entityManager.close();
		}
    }
	
	private Class<T> getGenericClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
//		if(entityManager == null || !(entityManager.isOpen())){
			return emf.createEntityManager();
//		}
//		return entityManager;
	}
	public  Boolean verificaUsuario(String valor){
		entityManager = getEntityManager();	
		entityManager.getTransaction().begin();
		String jpql = "select a from Usuario a where a.usuario= :valorx";
																			
		Query query = entityManager.createQuery(jpql);
		query.setParameter("valorx", valor);

		entityManager.getTransaction().commit();
		lista = query.getResultList();
		
		if(lista.size() > 0){
			return true;
		}else{
			return false;
		}
	}
}
