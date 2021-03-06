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
		<div class=greeting>
		<p>Hello, <c:out value="${user.userName}"></c:out> , Welcome to...</p>
		<h1>The Book Broker!</h1>
		</div>
		<div class=links>
		<p><a href="/logout">Logout</a></p>
		<p><a href="/logout">Back to the shelves</a></p>
		</div>
	</div>
	<div class=content>
		<p>Available Books to Borrow</p>
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Action</th>	
			</tr>
			<c:forEach var="book" items="${availableBooks}" >
			<tr>
				<td>
					<c:out value="${book.id}"/>
				</td>
				<td>
					<a href="/books/${book.id}"><c:out value="${book.title}"/></a>
				</td>
				<td>
					<c:out value="${book.authorName()}"/>
				</td>
				<td>
					<c:out value="${book.user.userName()}"/>
				</td>
			<c:choose>
    		<c:when test="${book.user.id == user.id}">
				<td>
					<a href="/books/edit/${book.id}">Edit</a>|<a href="/books/delete/${book.id}">Delete</a>
				</td>        
    		</c:when>    
   			<c:otherwise>
       			<td>
       				<a href="/borrows/${book.id}">Borrow</a>
				</td>
    		</c:otherwise>
			</c:choose>	
			</tr>
			</c:forEach>
</table>
		
		<p>Books I'm Borrowing...</p>
		<table class="table table-striped table-bordered table-hover">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Action</th>	
			</tr>
			<c:forEach var="book" items="${barrowedBooks}" >
			<tr>
				<td>
					<c:out value="${book.id}"/>
				</td>
				<td>
					<a href="/books/${book.id}"><c:out value="${book.title}"/></a>
				</td>
				<td>
					<c:out value="${book.authorName}"/>
				</td>
				<td>
					<c:out value="${book.user.userName}"/>
				</td>
				<td>
					<a href="/return/${book.id }">Return</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>

</body>
</html>