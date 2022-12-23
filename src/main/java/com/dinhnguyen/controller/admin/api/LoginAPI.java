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
@WebServlet(urlPatterns = {"/api-admin-login"})
public class LoginAPI extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		UserModel usmodel  =httpUtil.of(req.getReader()).toUsers(UserModel.class);
		usmodel = userService.FindonebyEmailandPassWord(usmodel.getEmail(),usmodel.getPassword());
		mapper.writeValue(res.getOutputStream(), usmodel);
			}
}
