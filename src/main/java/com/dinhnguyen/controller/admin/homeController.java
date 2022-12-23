package com.dinhnguyen.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin-home"})
public class homeController extends HttpServlet {

	private static final long serialVersionUID = 8533934601025223038L;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/home.jsp");
		requestDispatcher.forward(req, res);
			    
			}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {

			    
			}
}
