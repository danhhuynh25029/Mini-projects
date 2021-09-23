<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String method = request.getParameter("name"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
<h1 align="center">Insert</h1>
<form action="insert" method="POST">
<table align="center" >
<tr>
  <td><label>Name : </label></td>
  <td><input type="text" name="name"></td>
</tr>
<tr>
<td><label>Phone : </label></td>
<td><input type="text" name="phone"></td>
</tr>
<tr colspan="2">
	<td><input type="submit"></td>
</tr>
</table>
</form>
</body>
</html>