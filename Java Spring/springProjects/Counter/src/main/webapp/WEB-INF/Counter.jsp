<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<span class="support tag open from-rainbow"></span><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><span class="support tag close from-rainbow"></span>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h2>You have visited <a href="/your_server">http://your_server</a> <c:out value="${countToShow+1}"/> </h2>
<p><a href="/your_server">Test Another Visit</a></p>
</body>
</html>