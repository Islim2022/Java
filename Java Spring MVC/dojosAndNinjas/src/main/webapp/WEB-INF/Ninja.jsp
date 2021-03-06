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
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
	    <div class="form-group">
	    	<form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input type="text" path="firstNname"/>
	    </div>
	    <div class="form-group">
	    	<form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input type="text" path="lastNname"/>
	    </div>
	    <div class="form-group">
	    	<form:label path="age">Age:</form:label>
	        <form:errors path="age"/>
	        <form:input type="text" path="age"/>
	    </div>
	    <div class="form-group">
	    	<form:label path="dojo">Select Dojo:</form:label>
	        <form:errors path="dojo"/>
	        <form:select path="dojo">
	        	<c:forEach  var="dojo" items="${dojos}">	
	        		<form:option value="${dojo}">
	        			<c:out value="${dojo.name}"/>
	        		</form:option>
	        	</c:forEach>
	        </form:select>
	    </div>
	    <input type="submit" class="btn btn-primary" value="Create"/>
	</form:form> 
</div>

</body>
</html>