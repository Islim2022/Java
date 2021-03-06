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
<link rel="stylesheet" href="css/Style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div id=container >
	<div id=all-expenses >
	<h1>Save Travels</h1>
<table class="table table-striped table-bordered table-hover">
    <thead>
        <tr>
            <th>ID</th>
            <th>Expenses</th>
            <th>Vendor</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach  var="expense" items="${expenses}">
         		<tr>
         			<td><c:out value="${expense.id }"></c:out></td>
         			<td><c:out value="${expense.expense }"></c:out></td>
         			<td><c:out value="${expense.vendor }"></c:out></td>
         			<td><c:out value="${expense.amount }"></c:out></td>
         			<td><a href="/expenses/edit/${expense.id}">Edit</a>
         		</tr>
         </c:forEach>
    </tbody>
</table>
</div>
<div id=form >
   
<h1>Add an Expense</h1>
<form:form action="/addExpenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="expense">Expense</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Price</form:label>
        <form:errors path="amount"/>     
        <form:input path="amount"/>
    </p>    
    <input id=button type="submit" value="Submit"/>
</form:form>    

	
</div>
</div>

</body>
</html>