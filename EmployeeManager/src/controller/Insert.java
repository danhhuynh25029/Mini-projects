package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import model.EmployeeController;
@WebServlet(urlPatterns= {"/insert"})
public class Insert extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name","i");
		RequestDispatcher rd = req.getRequestDispatcher("webapp/form.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		int code = name.hashCode();
		try {
			EmployeeController.Insert(name, phone, code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("home");
	}
}
