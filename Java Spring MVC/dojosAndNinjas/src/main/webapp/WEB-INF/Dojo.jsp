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
	<h1>New Dojo</h1>
	<form:form action="/dojos/new" method="post" modelAttribute="dojo">
	    <div class="form-group">
	    	<form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input type="text" class="form-control" path="name"/>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Create"/>
	</form:form> 
</div>

</body>
</html>