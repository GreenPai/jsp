package com.ssamz.web.common;


import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter(urlPatterns = "*.do")
public class TimeCheckFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public TimeCheckFilter() {
		System.out.println("===> TimeCheckFilter ");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("---> init() ");
	}
		
	public void doFilter(ServletRequest request, ServletResponse response, 
	FilterChain chain) throws IOException, ServletException {
		System.out.println("---> doFilter()");
		System.out.println("------");
		chain.doFilter(request, response);
		System.out.println("------");
	}
	
	public void destroy() {
		System.out.println("---> destroy() ");
	}
}
