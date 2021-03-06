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
<link rel="stylesheet" href="css/Style1.css"/>
</head>
<body>
    <div class="container">
        <div class="forms">
            <div class="form-group">
                <h2>Registration</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
				    <div class="form-group">
				    	<form:label path="userName">User Name</form:label>
				        <form:errors path="userName"/>
				        <form:input type="text" path="userName"/>
				    </div>
				    <div class="form-group">
				    	<form:label path="email">Email</form:label>
				        <form:errors path="email"/>
				        <form:input type="text" path="email"/>
				    </div>
				    <div class="form-group">
				    	<form:label path="password">Password</form:label>
				        <form:errors path="password"/>
				        <form:input type="text" path="password"/>
				    </div>
				    <div class="form-group">
				    	<form:label path="confirm">Confirm Password</form:label>
				        <form:errors path="confirm"/>
				        <form:input type="text" path="confirm"/>
				    </div>
                	<button class="btn btn-outline-primary" type="submit">Register</button>
                </form:form>
            </div>
            <div class="login-form">
                <h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin">
				    <div class="form-group">
				    	<form:label path="email">Email</form:label>
				        <form:errors path="email"/>
				        <form:input type="text" path="email"/>
				    </div>
				    <div class="form-group">
				    	<form:label path="password">Password</form:label>
				        <form:errors path="password"/>
				        <form:input type="text" path="password"/>
				    </div>
                    <button class="btn btn-outline-primary" type="submit">Login</button>
                 </form:form>
                
            </div>
        </div>
    </div>
    
</body>
</html>