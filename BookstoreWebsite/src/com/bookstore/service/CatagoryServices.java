package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CatagoryServices {

	private CategoryDAO categorydao;
	private EntityManagerFactory emf;
	private EntityManager em;
	HttpServletRequest request;
	HttpServletResponse response;
	public CatagoryServices(HttpServletRequest request,HttpServletResponse response) {
		emf = Persistence.createEntityManagerFactory("BookStoreWebsite");
		em =emf.createEntityManager();
		categorydao = new CategoryDAO(em);
		this.request=request;
		this.response=response;
	}
	public void listCategory() throws ServletException, IOException {		
		List<Category> listallcategories = categorydao.listAll();
		request.setAttribute("listallcategories",listallcategories);
		String page="Category_list.jsp";
		RequestDispatcher redispathcer=request.getRequestDispatcher(page);
		redispathcer.forward(request, response);
		}
	public void listCategory(String message) throws ServletException, IOException {		
		List<Category> listallcategories = categorydao.listAll();
		request.setAttribute("listallcategories",listallcategories);
		request.setAttribute("message", message);
		String page="Category_list.jsp";
		RequestDispatcher redispathcer=request.getRequestDispatcher(page);
		redispathcer.forward(request, response);
		}
	public void createCategory() throws ServletException, IOException {
		String categoryname=request.getParameter("CategoryName");
		System.out.println(categoryname);
		Category category=new Category(categoryname);
		categorydao.create(category);
		Integer id=category.getCategoryId();
		String message="Category with id "+id+" created sucessfully";
		listCategory(message);
	}
	public void editCategory() throws ServletException, IOException {
		Integer categoryid=Integer.parseInt(request.getParameter("id"));
		Category newcategory=categorydao.get(categoryid);
		if(newcategory==null) {
			String Message="Category with id "+categoryid+" does not exist";
			listCategory(Message);
		}
		else
		{
			request.setAttribute("editCategory", newcategory);
			String page="Category_form.jsp";
			RequestDispatcher redispathcer=request.getRequestDispatcher(page);
			redispathcer.forward(request, response);
			
		}
	}
	public void UpdateCategory() {
		System.out.println("abc");
		
	}
}
