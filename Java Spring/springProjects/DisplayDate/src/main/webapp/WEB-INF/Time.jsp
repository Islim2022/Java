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
	<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
	<script type="text/javascript" src="js/Time.js"></script>
</head>
<body>
<h1><c:out value="{%time}"></c:out></h1>
</body>
</html>