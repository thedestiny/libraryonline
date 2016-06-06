package com.login.it;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

import com.dao.it.AdminDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	AdminDAO dao = new AdminDAO();
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null;
		String code = null;
		Cookie[] cookies = request.getCookies();
		// System.out.println(cookies == null);
		
		if(cookies != null && cookies.length >= 2){
			for (Cookie cook : cookies) {
				if(cook.getName().equals("name")){
					name = cook.getValue();
				}
				if(cook.getName().equals("code")){
					code = cook.getValue();
				}
				boolean bool = (name != null && code != null);
				if(bool && dao.find(name, code)){
					HttpSession session = request.getSession();
					session.setAttribute("name", name);
					session.setAttribute("code", code);
					// System.out.println("123456");
					response.sendRedirect("/home");
				}		
			}
		}
		System.out.println("here you are!");
		request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String name = request.getParameter("user");
		String code = request.getParameter("pwd");
		
		if(dao.find(name, code)){
			String dog = request.getParameter("dog");
			if("remember".equals(dog)){
				Cookie ck1 = new Cookie("name", name);
				Cookie ck2 = new Cookie("code", code);
				ck1.setMaxAge(3600*24*15);
				ck1.setPath("/");
				ck1.setHttpOnly(true);
				ck2.setMaxAge(3600*24*15);
				ck2.setPath("/");
				ck2.setHttpOnly(true);
				response.addCookie(ck1);
				response.addCookie(ck2);
			}
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("code", code);
			// System.out.println("123456");
			response.sendRedirect("/home");
			//response.sendRedirect("/home");
			
		} else{
			// response.sendRedirect("/index.jsp?err=1001");
			request.getRequestDispatcher("/WEB-INF/views/index.jsp?err=1001").forward(request, response);
		} 
	}
}
