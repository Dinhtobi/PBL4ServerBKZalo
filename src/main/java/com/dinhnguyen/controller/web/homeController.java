package com.dinhnguyen.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.Admin;
import com.dinhnguyen.service.IAdminService;
import com.dinhnguyen.util.Formutil;
import com.dinhnguyen.util.SessionUtil;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class homeController extends HttpServlet {
	
	
	@Inject
	private IAdminService adminService;
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	private static final long serialVersionUID = 8533934601025223038L;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {
			String action = req.getParameter("action");
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
			requestDispatcher.forward(req, res);
		if(action != null && action.equals("logout")){
			SessionUtil.getInstance().removeValue(req, "Admin");
			res.sendRedirect(req.getContextPath() + "/dang-nhap");
		}
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			Admin admin  =Formutil.toAdmin(Admin.class, req);
			admin = adminService.findByUsernameandPasswordandTrangthai(admin.getUsername(), admin.getMatkhau());
			
			if(admin != null) {
				SessionUtil.getInstance().putValue(req, "Admin", admin);
				res.sendRedirect(req.getContextPath() +"/admin-home");
			}else {
				res.sendRedirect(req.getContextPath() +"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		}
			    
	}
}
