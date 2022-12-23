package com.dinhnguyen.controller.admin.api;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/api-admin-offline"})
public class OfflineAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		UserModel user = httpUtil.of(req.getReader()).toUsers(UserModel.class);
		userService.SetStatusOff(user.getId());
		mapper.writeValue(res.getOutputStream(), user);
	}
}
