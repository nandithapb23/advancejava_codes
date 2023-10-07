<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
<th>Id</th>
<th>Name</th>
<th>salary</th>
<th>phone</th>
<th>delete</th>
</tr>
<c:forEach var="employee" items="${employee}">
<tr>
<td>${employee.id}</td>
<td>${employee.name}</td>
<td>${employee.salary}</td>
<td>${employee.phone}</td>
<td><a href="delete?id=${employee.id}">delete</a>
<td><a href="edit?id=${employee.id}">edit</a>

</tr>
</c:forEach>
</table>
</body>
</html>