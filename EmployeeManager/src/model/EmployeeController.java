package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import database.DatabaseConnection;;

public class EmployeeController {
	private static final String URL = "jdbc:mysql://localhost:3306/EmployeeManager";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin12345";
	public static ArrayList<Employee> getAllEmployee() throws SQLException{
		String sql = "SELECT * FROM employee";
		Connection con = DatabaseConnection.getJDBCConnection(URL,USERNAME,PASSWORD);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		ArrayList<Employee> ls = new ArrayList<>(); 
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			ls.add(e);
		}
		return ls;
	}
	public static void Delete(int id) throws SQLException {
		String sql = "DELETE FROM employee WHERE id =? ";
		Connection con = DatabaseConnection.getJDBCConnection(URL,USERNAME,PASSWORD);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		int rs = st.executeUpdate();
		System.out.println(rs);
	}
	public static void Insert(String name,String phone,int code) throws SQLException {
		String sql = "INSERT INTO employee(name,phone,code) VALUES(?,?,?)";
		Connection con = DatabaseConnection.getJDBCConnection(URL,USERNAME,PASSWORD);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,name);
		st.setString(2,phone);
		st.setInt(3, code);
		int rs = st.executeUpdate();
	}
	public static void Update(int id,String name,String phone,int code) throws SQLException {
		String sql = "UPDATE employee SET name=?,phone=?,code=? WHERE id=?";
		Connection con = DatabaseConnection.getJDBCConnection(URL, USERNAME, PASSWORD);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,name);
		st.setString(2,phone);
		st.setInt(3, code);
		st.setInt(4, id);
		int rs = st.executeUpdate();
	}
	public static void main(String[] args) throws SQLException {
		ArrayList<Employee> ls = getAllEmployee();
		for(Employee e : ls) {
			System.out.println(e.getName());
		}
	}
}
