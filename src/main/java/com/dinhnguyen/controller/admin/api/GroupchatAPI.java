package com.dinhnguyen.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.model.UserModel;
import com.dinhnguyen.service.IGroupchatService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-groupchat"})
public class GroupchatAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IGroupchatService idGroupchatService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		GroupChat nc = httpUtil.of(req.getReader()).toUsers(GroupChat.class);
		nc = idGroupchatService.save(nc);
		mapper.writeValue(res.getOutputStream(), nc);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		GroupChat nc = httpUtil.of(req.getReader()).toUsers(GroupChat.class);
		
		idGroupchatService.Update(nc);
		mapper.writeValue(res.getOutputStream(), "Da cap nhat");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		GroupChat nc = httpUtil.of(req.getReader()).toUsers(GroupChat.class);
		idGroupchatService.Update(nc);
		mapper.writeValue(res.getOutputStream(), "Đã xoá");
	}

}
