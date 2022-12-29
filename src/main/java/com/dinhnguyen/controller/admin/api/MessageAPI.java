package com.dinhnguyen.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.mapper.MessageMapper;
import com.dinhnguyen.model.Message;
import com.dinhnguyen.service.IMessageService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet(urlPatterns = {"/api-admin-message"})
public class MessageAPI  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private IMessageService messageService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		Message mes = httpUtil.of(req.getReader()).toUsers(Message.class);
		mes = messageService.save(mes);
		mapper.writeValue(res.getOutputStream(), mes);
	}

}
