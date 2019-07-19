package com.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.bookstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users> {

	public UserDAO(EntityManager entitymanager) {
		super(entitymanager);
	}

	public Users create(Users user) {
		return super.create(user);
	}	
	@Override
	public Users update(Users user) {
		
		return super.Update(user);
	}

	@Override
	public Users get(Object userid) {	
		return super.find(Users.class, userid); 
	}

	@Override
	public void delete(Object userid) {
		
		super.Delete(Users.class, userid);
		
	}

	@Override
	public List<Users> listAll() {
		
		return super.findwithnamedquery("Users.findall");
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Users findByEmail(String email) {
		List<Users> listresult=super.findwithnamedquery("Users.findByEmail","email",email);
		if(listresult!=null && listresult.size()==1) {
			return listresult.get(0);
		}
		return null;
	}
	
	

}
 