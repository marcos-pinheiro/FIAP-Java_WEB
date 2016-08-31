package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> clazz;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.clazz = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + clazz.getSimpleName(), clazz).getResultList();
	}

	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(clazz, id);
		em.getTransaction().commit();
		em.close();

		return entidade;
	}
	
	@SuppressWarnings("unchecked")
	public T buscar(String nome, String senha) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<T> query = em.createQuery("From " + clazz.getSimpleName() + " WHERE nome = :nome and senha = :senha", clazz)
				.setParameter("nome", nome)
				.setParameter("senha", senha);
		
		Object entidade = query.getSingleResult();
		if(entidade == null)
			return null;
		
		em.getTransaction().commit();
		em.close();

		return (T) entidade;
	}

}
