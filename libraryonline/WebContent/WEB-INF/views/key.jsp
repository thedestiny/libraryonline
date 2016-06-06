<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Object nam = session.getAttribute("name");  
	// System.out.println("阿喀琉斯：  " + nam);
	if(nam == null){
		//request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
		// response.sendRedirect("/login");
	}
%>