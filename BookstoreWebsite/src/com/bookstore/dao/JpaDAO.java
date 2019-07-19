package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<T> {

	EntityManager entitymanager;
	
	public JpaDAO(EntityManager entitymanager) {
		super();
		this.entitymanager=entitymanager;
	}
	 public T create(T t) {
		 entitymanager.getTransaction().begin();
		 entitymanager.persist(t);
		 entitymanager.flush();
		 entitymanager.refresh(t);
		 entitymanager.getTransaction().commit();
		 return t;
	 }
	 public T Update(T t) {
		 entitymanager.getTransaction().begin();
		  t = entitymanager.merge(t);
		 entitymanager.flush();
		 entitymanager.refresh(t);
		 entitymanager.getTransaction().commit();
		 return t;
	 }
	 public T find(Class<T> type, Object id) {
		  T t=entitymanager.find(type, id);
		  if(t!= null) 
		  entitymanager.refresh(t);
		  return t;
	 }
	 public void Delete(Class<T> type, Object id) {
		 entitymanager.getTransaction().begin();
		  Object reference=entitymanager.getReference(type,id);
		  //System.out.print("hello");
		  entitymanager.remove(reference);
		  entitymanager.getTransaction().commit();
	 }
	 public List<T> findwithnamedquery(String query1){
		 Query query=entitymanager.createNamedQuery(query1);
		 return query.getResultList();
	 }
	 public List<T> findwithnamedquery(String query1,String paramName,Object paramValue){
		 Query query=entitymanager.createNamedQuery(query1);
		 query.setParameter(paramName, paramValue);
		 return query.getResultList();
	 }
	 
}
