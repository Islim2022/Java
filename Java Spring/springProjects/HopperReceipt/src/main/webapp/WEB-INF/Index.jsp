<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<span class="support tag open from-rainbow"></span>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<span class="support tag close from-rainbow"></span>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP</title>
        <link rel="stylesheet" type="text/css" href="/css/style.css">
		<script type="text/javascript" src="js/app.js"></script>
    </head>
<body>
    <h1>Customer Name: <c:out value="${name}"/></h1>
    <h2>Item Name: <c:out value="${itemName}"></c:out></h2>
    <h2>Price: <c:out value="${price}"></c:out></h2>
    <h2>Description: <c:out value="${description}"></c:out></h2>
    <h2>Vendor: <c:out value="${vendor}"></c:out></h2>
</body>
</html>