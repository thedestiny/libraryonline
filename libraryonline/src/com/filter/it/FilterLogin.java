package com.filter.it;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/FilterLogin")
public class FilterLogin implements Filter {

	private  String uris;
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }
   
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		boolean flag = false;
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String str = req.getRequestURI();
		System.out.println(str);
		String[] uri = uris.split(",");
		//System.out.println("URI:  " + str + "   URL:  " + req.getRequestURL().toString());
		for (String st : uri) {
			if(str.startsWith(st)){
				//System.out.println(st);
				flag = true;
			}
		}
		//System.out.println("卢比孔河");
		if(flag){
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			if(session.getAttribute("name") == null && session.getAttribute("custom") == null ){
				System.out.println("被重定向");
				res.sendRedirect("/custom");
			} else {
				chain.doFilter(request, response);
			}	
		} 
	}
	public void init(FilterConfig fConfig) throws ServletException {
		uris = fConfig.getInitParameter("uris");
	}

}
