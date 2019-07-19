package com.bookstore.service;

import java.io.IOException;
import java.util.*;

import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

public class UserServices {

	private UserDAO userdao;
	private EntityManagerFactory emf;
	private EntityManager em;
	HttpServletRequest request;
	HttpServletResponse response;
	public UserServices(HttpServletRequest request,HttpServletResponse response) {
		emf = Persistence.createEntityManagerFactory("BookStoreWebsite");
		em =emf.createEntityManager();
		userdao = new UserDAO(em);
		this.request=request;
		this.response=response;
	}
	
	public void listuser() throws ServletException, IOException {		
	List<Users> listallusers = userdao.listAll();
	request.setAttribute("allusers",listallusers);
	String page="user_list.jsp";
	RequestDispatcher redispathcer=request.getRequestDispatcher(page);
	redispathcer.forward(request, response);
	}
	public void listuser(String message) throws ServletException, IOException {		
		List<Users> listallusers = userdao.listAll();
		request.setAttribute("allusers",listallusers);
		request.setAttribute("message", message);
		String page="user_list.jsp";
		RequestDispatcher redispathcer=request.getRequestDispatcher(page);
		redispathcer.forward(request, response);
		}

	public void createuser() throws ServletException, IOException {
		String Email=request.getParameter("Email");
		String FullName=request.getParameter("FullName");
		String Password=request.getParameter("Password");
		Users user1=userdao.findByEmail(Email);
		if(user1==null) {
		Users user=new Users(Email,Password,FullName);		
		userdao.create(user);
		String message="User with mail id "+Email+" created successfully";
		//request.setAttribute("message", message);
		listuser(message);
		}
		else
		{
			String message="Email is alredy exist in System";
			listuser(message);
		}
		
	}

	public void Edituser() throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("id"));
		Users user=userdao.get(userid);
		if(user==null) {
			String message="Could not find user whith id:"+userid;
			request.setAttribute("message", message);
			String page="message.jsp";
			RequestDispatcher redispathcer=request.getRequestDispatcher(page);
			redispathcer.forward(request, response);
		}
		//System.out.println(user.getEmail());
		request.setAttribute("edituser",user);
		String page="user_form.jsp";
		RequestDispatcher redispathcer=request.getRequestDispatcher(page);
		redispathcer.forward(request, response);
		
	}

	public void updateuser() throws ServletException, IOException {
		Integer userId=Integer.parseInt(request.getParameter("userId"));
		String Email=request.getParameter("Email");	
		String FullName=request.getParameter("FullName");
		String Password=request.getParameter("Password");
		Users user1=userdao.findByEmail(Email);
		if (user1!=null && user1.getUserId()!=userId) {
			String errormessage="Could'nt update as Email id already exists";
			request.setAttribute("errormessage", errormessage);
			Users edituser=userdao.get(userId);
			request.setAttribute("edituser", edituser);
			String page="user_form.jsp";
			RequestDispatcher redispathcer=request.getRequestDispatcher(page);
			redispathcer.forward(request, response);
		}
		else {
			Users user=new Users(userId,Email,Password,FullName);
			userdao.update(user);
			String message="User updated successfully";
			listuser(message);
		}
	}

	public void Deleteuser() throws ServletException, IOException {
		Integer userId=Integer.parseInt(request.getParameter("id"));
		if (userId==1) {
			 String message="The default admin user account cannot be deleted.";
			 listuser(message);
		}
		Users user=userdao.get(userId);
		String page="user_list.jsp";
		if(user==null) {
			String message="Could not find user whith id:"+userId;
			request.setAttribute("message", message);
			page="message.jsp";
			
		}
		
		else {
			userdao.delete(userId);
			String message="user with user id:"+userId+" deleted successfully";
			listuser(message);
			
		}
		RequestDispatcher redispathcer=request.getRequestDispatcher(page);
		redispathcer.forward(request, response);
	}
	

	
	
}
