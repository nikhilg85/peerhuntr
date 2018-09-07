package com.infodart.peerhuntr.jpa.dao.impl.basedao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;

import com.infodart.peerhuntr.jpa.entity.user.AddDate;

@SuppressWarnings("unchecked")
public abstract class AbstractGenericDao<E> extends AddDate<E> implements GenericDao<E> {

	private final Class<E> entityClass;

	
	public AbstractGenericDao() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public E findById(final Serializable id) {
		return (E) getSession().get(this.entityClass, id);
	}

	@Override
	public Serializable save(E entity) {
		//AddDate addDate = new AddDate();
		return getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
	Session session=getSession();
	session.save(entity);
	flush();
	
	}

	 public void create( E entity ){
		 getSession().persist( entity );
	   }
	 
	   public void update( E entity ){
		   getSession().merge( entity );
	   }
	
	@Override
	public void delete(E entity) {
		getSession().delete(entity);
	}

	@Override
	public void deleteAll() {
		List<E> entities = findAll();
		for (E entity : entities) {
			getSession().delete(entity);
		}
	}

	@Override
	public List<E> findAll() {
		return getSession().createCriteria(this.entityClass).list();
	}

	@Override
	public List<E> findAllByExample(E entity) {
		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return getSession().createCriteria(this.entityClass).add(example).list();
	}
	

	@Override
	public void clear() {
		getSession().clear();

	}

	@Override
	public void flush() {
		getSession().flush();

	}
	 
	@Override
	public void setDate(AddDate<E> addDate) {
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		
		addDate.setCreatedOn(currentTime);
		addDate.setModifiedOn(currentTime);
	}

	
	
}
