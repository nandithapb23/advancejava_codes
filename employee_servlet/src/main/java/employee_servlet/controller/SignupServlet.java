package employee_servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee_servlet.dao.Employedao;
import employee_servlet.dto.Employee;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone")) ;
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		Employedao employedao=new Employedao();
		Employee employee2=employedao.savEmployee(employee);
		if(employee2!=null) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.html");
			dispatcher.include(req, resp);
		}
		
	}
}
