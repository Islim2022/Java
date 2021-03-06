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
		<h1>Hello, <c:out value="${user.userName}"></c:out> , Welcome.</h1>
		</div>
		<div class=links>
		<p><a href="/logout">Logout</a></p>
		</div>
	</div>
	<div class=content>
		<div class=title>
		<h3>Books from All Shells</h3>
		</div>
		<div class=links>
		<p><a href="/books/new">Add a Book To Your Shelf</a></p>
		<p><a href="/bookmarket">Book Market</a></p>
		</div>
		<div class=table>
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
				<c:forEach var="book" items="${books}" >
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
				</tr>
				</c:forEach>
			</table>
	</div>
		
</div>
</div>
</body>
</html>