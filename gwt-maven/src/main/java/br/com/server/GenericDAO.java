package br.com.server;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public class GenericDAO<T> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	
	/*public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}*/
	
	@Transactional
	public T findById(Long id) {
        return (T) entityManager.find(getTypeClass(), id);
    }

	@Transactional
	public void save(T entity) {
        try {
              this.entityManager.persist(entity);           
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().getRollbackOnly();
        }
    }
	
	@Transactional
	public void update(T entity) {
        try {
        	this.entityManager.merge(entity);
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().getRollbackOnly();
        }
    }
 
	@Transactional
    public void delete(T entity) {
        try {
        	this.entityManager.remove(entity);
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().getRollbackOnly();
        }
    }
 
	@Transactional
    public List<T> findAll() {
        return entityManager.createQuery(("From " + getTypeClass().getName())).getResultList();
    }
	
	private Class<?> getTypeClass() {
	        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	        return clazz;
	}
	
}
