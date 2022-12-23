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
import com.dinhnguyen.service.IUserService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = {"/api-admin-listmembergroupAPI"})
public class ListMemberGroupAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IUserService userService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		GroupChat ct = httpUtil.of(req.getReader()).toUsers(GroupChat.class);
		List<UserModel> list = userService.findAllbyid_nhomchat(ct.getId_nhomchat(), ct.getType());
		mapper.writeValue(res.getOutputStream(), list);
	}
}
