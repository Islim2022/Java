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
<div id=container >
	<div id=all-expenses >
	<h1>Save Travels</h1>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach  var="language" items="${languages}">
         		<tr>
         			<td><c:out value="${language.id }"></c:out></td>
         			<td><a href="/language/${language.id}"><c:out value="${language.name}"/></a></td>
         			<td><c:out value="${language.creator }"></c:out></td>
         			<td><c:out value="${language.version }"></c:out></td>
         			<td>
         				<a href="/languages/edit/${language.id}">Edit</a> | <a href="/languages/delete/${language.id}">Delete</a>
         			</td>
         		</tr>
         </c:forEach>
    </tbody>
</table>
</div>

<div id=form >
   
<h1>Add New Language</h1>
<form:form action="/languages" method="post" modelAttribute="language">
    <div class="form-input">
    	<form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </div>
    <div class="form-input">
        <form:label path="vendor">Creator:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </div>
    <div class="form-input">
        <form:label path="description">Version:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </div> 
    <input id=button type="submit" value="Submit"/>
</form:form>    
</div>
</div>
</body>
</html>