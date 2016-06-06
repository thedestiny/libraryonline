package com.book.it;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.it.BookDAO;
import com.dao.it.RecordDAO;
import com.entity.it.Book;
import com.servers.it.BRbook;

/**
 * Servlet implementation class BookBorrow
 */
@WebServlet("/BookBorrow")
public class BookBorrow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookBorrow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BookDAO bdao = new BookDAO();
	Book book = new Book();
	RecordDAO dao = new RecordDAO();
	BRbook br = new BRbook();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    String code = request.getParameter("id");
	    String ccode = request.getParameter("ccode");
	    if(ccode == null){
	    	book = bdao.find(code);
			request.setAttribute("book", book);
			request.getRequestDispatcher("/WEB-INF/views/bookborrow.jsp").forward(request, response);	
	    } else {
	    	String msg = br.borrowbook(code, ccode);
			// ?name1=value1&name2=value2
			response.sendRedirect("/inforcard?infor=" + ccode + "&msg=" + msg);
	    	
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String ccode = request.getParameter("ccode");
		String bcode = request.getParameter("code");
		String msg = br.borrowbook(bcode, ccode);
		// ?name1=value1&name2=value2
		response.sendRedirect("/inforcard?infor=" + ccode + "&msg=" + msg);
	}

}
