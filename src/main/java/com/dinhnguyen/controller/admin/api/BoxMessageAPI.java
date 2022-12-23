package com.dinhnguyen.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.HopChat;
import com.dinhnguyen.service.IBoxMessageService;
import com.dinhnguyen.util.httpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet(urlPatterns = {"/api-admin-boxmessage"})
public class BoxMessageAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IBoxMessageService iBoxMessageService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		HopChat hopChat = httpUtil.of(req.getReader()).toUsers(HopChat.class);
		if(hopChat.getType().equals("Check")) {
			hopChat = iBoxMessageService.findone(hopChat.getId_nguoigui(), hopChat.getId_nguoinhan(),hopChat.getId_nhomchat());
		}else {
			System.out.print(hopChat.getId_nhomchat());
			 iBoxMessageService.save(hopChat);
		}
		mapper.writeValue(res.getOutputStream(),  hopChat);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		HopChat hopChat = httpUtil.of(req.getReader()).toUsers(HopChat.class);
		iBoxMessageService.Update(hopChat);
		mapper.writeValue(res.getOutputStream(), "Da Update");
	}
}
