package br.com.dori.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public abstract class GenericDAO<T, ID extends Serializable> implements IGenericDAO<T, ID> {
	private Class<T> persistenceClass;
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor com o objetivo de informar qual classe será gravado no banco de dados
	 * @param persistenceClass Classe.class, classe que será gravado no banco
	 */
	public GenericDAO(Class<T> persistenceClass) {
		// TODO Auto-generated constructor stub
		this.persistenceClass = persistenceClass;
	}

	@Override
	@Transactional
	public T Insert(T entity) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.getEntityManager().persist(entity);	
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	@Override
	@Transactional
	public T Update(T entity) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.getEntityManager().merge(entity);
			return entity;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	@Override
	@Transactional
	public void Delete(T entity) throws Exception {
		// TODO Auto-generated method stub
		try {
			this.getEntityManager().remove(entity);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public T Find(ID id) throws NoResultException, Exception {
		// TODO Auto-generated method stub
		try {
			return this.getEntityManager().find(getPersistenceClass(), id);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<T> FindAll() throws NoResultException, Exception {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(getPersistenceClass());
			Root<T> root = criteria.from(this.getPersistenceClass());
			criteria.select(root);
			TypedQuery<T> query = this.getEntityManager().createQuery(criteria);
			
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	// Getter And Setters
	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
