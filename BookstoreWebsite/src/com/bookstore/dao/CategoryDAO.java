package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entitymanager) {
		super(entitymanager);
	}

	@Override
	public Category create(Category t) {
		return super.create(t);
	}

	@Override
	public Category update(Category t) {
		return super.Update(t);
	}

	@Override
	public Category get(Object categoryid) {
		return super.find(Category.class, categoryid);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> listAll() {
		return super.findwithnamedquery("Category.findall");
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
