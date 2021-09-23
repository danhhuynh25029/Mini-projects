package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseConnection;
import model.Employee;
import model.EmployeeController;

@WebServlet(urlPatterns= {"/home"})
public class ViewAll extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ArrayList<Employee> list = EmployeeController.getAllEmployee();
			if(list != null) {
				req.setAttribute("ls", list);
				System.out.println(list.size());
				RequestDispatcher rd = req.getRequestDispatcher("webapp/home.jsp");
				rd.forward(req, resp);
			}else {
				System.out.println("loi");
			}
			
		} catch (SQLException e) {
			System.out.println("Loi roi");
			e.printStackTrace();
		} 
		
	}
}
