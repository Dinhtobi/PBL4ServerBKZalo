package com.dinhnguyen.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.constant.SystemConstant;
import com.dinhnguyen.model.DetailGroupChat;
import com.dinhnguyen.model.GroupChat;
import com.dinhnguyen.paging.PageRequest;
import com.dinhnguyen.paging.Pageble;
import com.dinhnguyen.service.IDetailgroupchatService;
import com.dinhnguyen.service.IGroupchatService;
import com.dinhnguyen.sort.Sorter;
import com.dinhnguyen.util.Formutil;

@WebServlet(urlPatterns = { "/admin-group" })
public class GroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IGroupchatService groupchatService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		GroupChat model = Formutil.toUsers(GroupChat.class, req);
		String view = "";
		
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			model.setKq(groupchatService.findAll(pageble));
			model.setTotalItem(groupchatService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
			view = "/views/admin/Group/list.jsp";
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId_nhomchat()!=null) {
				model = groupchatService.findone(model.getId_nhomchat());
			}else {
				
			}
			view = "/views/admin/Group/edit.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
		requestDispatcher.forward(req, res);
	}
}
