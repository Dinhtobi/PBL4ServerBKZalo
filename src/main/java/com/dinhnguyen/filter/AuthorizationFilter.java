package com.dinhnguyen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dinhnguyen.model.Admin;
import com.dinhnguyen.util.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();

		if (url.startsWith("/Test-web/admin")) {
			Admin model = (Admin) SessionUtil.getInstance().getValue(request,"Admin");
			
			if (model != null) {
				filterchain.doFilter(servletRequest, servletResponse);
			} else {
				response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else {
			filterchain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {

	}
}
