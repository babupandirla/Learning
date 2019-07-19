package com.bookstore.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.CatagoryServices;

@WebServlet("/admin/list_Categories")
public class ListCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListCategories() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatagoryServices categoryservices= new CatagoryServices(request,response);
		categoryservices.listCategory();
	}

}
