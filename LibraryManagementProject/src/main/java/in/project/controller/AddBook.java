package in.project.controller;
import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.project.dao.*;
import in.project.model.Books;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet{
private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Books book = new Books();
	BookDAO bookadd = new BookDAOImp();
	
	String bname	 = request.getParameter("bname");
	int bid			 = Integer.parseInt(request.getParameter("bid"));
	String bauthor 	 = request.getParameter("bauthor");
	String bsubject	 = request.getParameter("bsubject");
	
	book.setBauthor(bauthor);
	book.setBid(bid);
	book.setBname(bname);
	book.setBsubject(bsubject);
	
	//bookadd = BookDAOImp();
	String baddstatus = bookadd.save(book);
	HttpSession session = request.getSession();
	session.setAttribute("baddstatus", baddstatus);
	
	response.sendRedirect("addBook.jsp");
	
	}

	@SuppressWarnings("unused")
	private BookDAO BookDAOImp() {
		// TODO Auto-generated method stub
		return null;
	}

	
}