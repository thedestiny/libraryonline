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
 * Servlet implementation class BookReturn
 */
@WebServlet("/BookReturn")
public class BookReturn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReturn() {
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
	    String bcode = request.getParameter("bcode");
	    String ccode = request.getParameter("ccode");
	    String msg = br.returnbook(bcode, ccode);
	    response.sendRedirect("/inforcard?infor=" + ccode + "&msg=" + msg);
	    
//	    String msgs = br.returnbook(bcode);
//	    String[] arr = msgs.split(",");
//	    String infor = arr[1];
//	    String msg =arr[0];
//	    response.sendRedirect("/inforcard?infor=" + infor + "&msg=" + msg);
//	    Boolean bool = dao.update(bcode, ccode);
//	    if(bool){
//	    	response.sendRedirect("/inforcard?infor=" + ccode);
//	    } else {
//	    	response.sendError(400, "¹é»¹Ê§°Ü£¡");
//	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
