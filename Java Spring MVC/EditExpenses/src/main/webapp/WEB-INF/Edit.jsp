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
<div id=container>
	<h1>Edit Expense</h1>
	<div id="expenses">
    	<form:form action="/update/${expense.id}" method="post" modelAttribute="expense">
        	<div class="form-input">
        		<form:label path="expense">Expense</form:label>
        		<form:errors path="expense"/>
        		<form:input path="expense" value="${expense.expense}"/>
            </div>
            <div class="form-input">
        		<form:label path="vendor">Vendor</form:label>
        		<form:errors path="vendor"/>
        		<form:input path="vendor" value="${expense.vendor}"/>
            </div>
            <div class="form-input">
        		<form:label path="description">Description</form:label>
        		<form:errors path="description"/>
        		<form:textarea path="description" value="${expense.description}"/>
            </div>
            <div class="form-input">
        		<form:label path="price">Price</form:label>
        		<form:errors path="price"/>
        		<form:input path="price" value="${expense.price}"/>
            </div>
            <input id=button type="submit" value="Update"/>
         </form:form>
	</div>	
</div>
</body>
</html>