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
	<div class=header>
		<div class=title>
		<h1>Change Your Entry</h1>
		</div>
		<div class=link>
		<p><a href="/books">back to the shelves</a></p>
		</div>
	</div>
	<div class=content>
		<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
    	<input type="hidden" name="_method" value="put">
    	<div class="form-group">
	    	<form:label path="title">Title:</form:label>
	        <form:errors path="title"/>
	        <form:input type="text" path="title" value="${book.title}"/>
	    </div>
	    	    <div class="form-group">
	    	<form:label path="author">Author Name:</form:label>
	        <form:errors path="author"/>
	        <form:input type="text" path="author" value="${book.author}" />
	    </div>
	    <div class="form-group">
	    	<form:label path="userThought">Your Thought:</form:label>
	        <form:errors path="userThought"/>
	        <form:input type="text" path="userThought" value="${book.userThought}"/>
	    </div>
		<input type="submit" class="btn btn-primary" value="Submit"/>
		<a href="/books/delete/${book.id}"><input type="submit" class="btn btn-primary" value="Delete Book" /></a>
		</form:form> 
	</div>
</div>

</body>
</html>