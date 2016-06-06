package com.login.it;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.it.CardDAO;
import com.entity.it.Card;

/**
 * Servlet implementation class Custom
 */
@WebServlet("/Custom")
public class Custom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Custom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    CardDAO dao = new CardDAO();		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null;
		String code = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cook : cookies) {
				if(cook.getName().equals("custom")){
					name = cook.getValue();
				}
				if(cook.getName().equals("pass")){
					code = cook.getValue();
				}
				boolean bool = (name != null && code != null);
				Card card = dao.login(name, code);
				if(bool &&  card == null){
					HttpSession session = request.getSession();
					session.setAttribute("user", card.getUser());  // 用户名
					session.setAttribute("custom", name);  // 卡号
					// System.out.println("123456");
					response.sendRedirect("/home");
				}		
			}
		}
		System.out.println("custom :here you are!");
		request.getRequestDispatcher("/WEB-INF/views/custom.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("custom"); // 卡号
		String code = request.getParameter("pass");  // 密码
		Card card = dao.login(name, code);
		System.out.println("在这里");
		if(card != null){
			String dog = request.getParameter("dog");
			if("remember".equals(dog)){
				Cookie ck1 = new Cookie("custom", name);
				Cookie ck2 = new Cookie("pass", code);
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
			session.setAttribute("user", card.getUser());  // 用户名
			session.setAttribute("custom", name);  // 卡号
			System.out.println("123456");
			response.sendRedirect("/home");
			//response.sendRedirect("/home");
			
		} else{
			// response.sendRedirect("/index.jsp?err=1001");
			request.getRequestDispatcher("/WEB-INF/views/custom.jsp?err=1001").forward(request, response);
		} 
	}
	

}
