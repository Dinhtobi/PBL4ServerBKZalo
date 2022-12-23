package com.dinhnguyen.controller.admin;

import java.io.IOException;

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
import com.dinhnguyen.sort.Sorter;
import com.dinhnguyen.util.Formutil;
@WebServlet(urlPatterns = {"/admin-detailgroup"})
public class DetailGroupController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Inject
	private IDetailgroupchatService detailgroupchatService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		DetailGroupChat model = Formutil.toUsers(DetailGroupChat.class, req);
		String view = "";
		
		if (model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			System.out.print(model.getId_nhomchat());
			model.setKq(detailgroupchatService.findAll(pageble,model.getId_nhomchat()));
			model.setTotalItem(detailgroupchatService.getTotalItem(model.getId_nhomchat()));
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, model);
			view = "/views/admin/DetailGroup/list.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
		requestDispatcher.forward(req, res);
	}
}
