package com.dinhnguyen.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.service.IUserService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-online"})
public class OnlineAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		List<UserModel> list = userService.findAll();
		mapper.writeValue(res.getOutputStream(), list);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		UserModel user = httpUtil.of(req.getReader()).toUsers(UserModel.class);
		userService.SetStatusOnl(user.getId());
		mapper.writeValue(res.getOutputStream(), user);
	}
	
}
