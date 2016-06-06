package com.filter.it;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class FilterEcode implements Filter {
	private String code;
    public FilterEcode() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// code ²»¼ÓÒýºÅ
		request.setCharacterEncoding(code);
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		code = fConfig.getInitParameter("code");
	}

}
