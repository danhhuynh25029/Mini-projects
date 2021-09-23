<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Employee"%>
<%@ page import="java.util.*" %>
<% ArrayList ls = (ArrayList)request.getAttribute("ls"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<a href="insert?name=i">INSERT</a>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">PhoneNumber</th>
      <th scope="col">Code</th>
      <th scope="col">Remove</th>
      <th scope="col">Update</th>
    </tr>
  </thead>
  <tbody>
  <% if(ls.size() > 0){%>
  	<%for(int i = 0 ; i < ls.size() ; i++){ %>
  	<%	Employee e = (Employee)ls.get(i); %>
    <tr>
      <th scope="row"><%= e.getId() %></th>
      <td><%= e.getName() %></td>
      <td><%= e.getPhoneNumber() %></td>
      <td><%= e.getCode() %></td>
      <td><a href="delete?id=<%=e.getId()%>">Remove</a></td>
      <td><a href="update?id=<%=e.getId() %>&name=<%= e.getName()%>&phone=<%=e.getPhoneNumber()%>">Update</a></td>
    </tr>
    <%} %>
    <%} %>
  </tbody>
</table>
</body>
</html>