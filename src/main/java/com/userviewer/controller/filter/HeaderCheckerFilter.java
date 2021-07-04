package com.userviewer.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.userviewer.service.UserService;


@Component
public class HeaderCheckerFilter implements Filter {
	
	@Autowired
	private UserService userService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
        String header = req.getHeader("request-user-id");
        if(header == null || header.isEmpty()) {
        	res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        	res.getWriter().println("invalid request");
        }else {
        	
        	if (userService.isUserExists(Long.valueOf(header))){
        		chain.doFilter(request, response);
        	}else {
        		res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        		res.getWriter().println("invalid request");
        	}
        	
        }		
	}
}