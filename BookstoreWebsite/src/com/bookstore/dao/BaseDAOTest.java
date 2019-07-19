package com.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {
	public static EntityManagerFactory entitymanagerfactory;
	protected static EntityManager entitymanager;
	
	protected  static void setUpBeforeClass() throws Exception {
		entitymanagerfactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entitymanager = entitymanagerfactory.createEntityManager();
	}
	protected static void tearDownAfterClass() throws Exception {
		entitymanager.close();
		entitymanagerfactory.close();
	}
}
