<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id"); 
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">update</h1>
<form action="update" method="POST">
<table align="center">
<tr>
	<td><lable>Id : <%= id %> </lable><td>
</tr>
<tr>
	<td><lable>Name : </lable></td>	
	<td><input type="text" name="name" value=<%= name %>></td>
</tr>
<tr>
	<td><label>Phone : </label></td>
	<td><input type="text" name="phone" value=<%= phone %>></td>
</tr>
<tr>
	<td><input type="submit" value="submit"><td>
</tr>
</table>
</form>
</body>
</html>