<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"/> 
<link rel="stylesheet" href="css/Style.css"/>
</head>
<body>
<div class=container>
	<h1><c:out value="${dojo.name }"/> Ninjas</h1>
	<table class= "table table-striped table-dark table-hover">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojo.ninjas}" var="ninja">
			<tr>
				<td><c:out value="${ninja.firstName}"/></td>
				<td><c:out value="${ninja.lastName}"/></td>
				<td><c:out value="${ninja.age}"/></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

</div>

</body>
</html>