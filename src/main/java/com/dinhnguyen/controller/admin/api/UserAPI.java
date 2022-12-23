package com.dinhnguyen.controller.admin.api;



import java.io.IOException;

import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.constant.SystemConstant;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.paging.PageRequest;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IUserService;
import com.dinhnguyen.sort.Sorter;
import com.dinhnguyen.util.Formutil;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet(urlPatterns = {"/api-admin-user"})
public class UserAPI extends HttpServlet {
	@Inject
	private IUserService newService; 
	private static final long serialVersionUID = -1627840988604344075L;
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException  {
			ObjectMapper mapper = new ObjectMapper();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("application/json");
			UserModel usmodel  =httpUtil.of(req.getReader()).toUsers(UserModel.class);
			usmodel = newService.save(usmodel);
			mapper.writeValue(res.getOutputStream(), usmodel);
			}
			
	public void doPut(HttpServletRequest req, HttpServletResponse res) throws
			  ServletException, IOException {
				 ObjectMapper mapper = new ObjectMapper();
				req.setCharacterEncoding("UTF-8");
				res.setContentType("application/json");
				UserModel USUpdate  =httpUtil.of(req.getReader()).toUsers(UserModel.class);
				USUpdate = newService.Update(USUpdate);
				mapper.writeValue(res.getOutputStream(), USUpdate);
			  } 
	public void doDelete(HttpServletRequest req, HttpServletResponse res)
			  throws ServletException, IOException {
				ObjectMapper mapper = new ObjectMapper();
				req.setCharacterEncoding("UTF-8");
				res.setContentType("application/json");
				UserModel USdel  =httpUtil.of(req.getReader()).toUsers(UserModel.class);
				newService.Delete(USdel.getIds());
				mapper.writeValue(res.getOutputStream(), "{ }");
			 }
			
}
