package com.dinhnguyen.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.service.IDetailgroupchatService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet(urlPatterns = {"/api-admin-detailgroupchat"})
public class DetailGroupchatAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IDetailgroupchatService iDetailgroupchatService; 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		DetailGroupChat ct = httpUtil.of(req.getReader()).toUsers(DetailGroupChat.class);
		iDetailgroupchatService.SaveorUpdate(ct);
		mapper.writeValue(res.getOutputStream(), "Success");
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		DetailGroupChat ct = httpUtil.of(req.getReader()).toUsers(DetailGroupChat.class);
		iDetailgroupchatService.Update(ct);
		mapper.writeValue(res.getOutputStream(), "Success");
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		DetailGroupChat ct = httpUtil.of(req.getReader()).toUsers(DetailGroupChat.class);
		iDetailgroupchatService.Del(ct);
		mapper.writeValue(res.getOutputStream(), ct);
	}
}
