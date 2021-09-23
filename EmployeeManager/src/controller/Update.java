package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeController;

@WebServlet(urlPatterns= {"/update"})
public class Update extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("id", req.getParameter("id"));
		req.setAttribute("name",req.getParameter("name"));
		req.setAttribute("phone", req.getParameter("phone"));
		RequestDispatcher rd = req.getRequestDispatcher("webapp/update.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.valueOf(req.getParameter("id"));
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		int code = name.hashCode();
		try {
			EmployeeController.Update(id,name,phone,code);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("home");
	}
}
