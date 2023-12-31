package in.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.project.dao.StudentDAO;
import in.project.dao.StudentDAOImp;
import in.project.model.Student;

@WebServlet("/DelStudent")
public class DeleteStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int sid = Integer.parseInt(request.getParameter("student-id"));
	String delstatus = null;
	StudentDAO student = null;
	Student std = new Student();
	student = new StudentDAOImp();
    std = student.findById(sid);
    if(std!=null)
    {
    	delstatus = student.deleteById(sid);
    }
    HttpSession session = request.getSession();     
    session.setAttribute("delstatus",delstatus);
    response.sendRedirect("delstudent.jsp");
	}
}
