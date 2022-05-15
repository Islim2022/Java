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
<div id=container>
	<h1>Edit Language</h1>
	<div id="languages">
    	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
    		<input type="hidden" name="which_language" value="put">
        	<div class="form-input">
        		<form:label path="name">Name</form:label>
        		<form:errors path="name"/>
        		<form:input path="name" value="${language.name}"/>
            </div>
            <div class="form-input">
        		<form:label path="creator">Creator</form:label>
        		<form:errors path="creator"/>
        		<form:input path="creator" value="${language.creator}"/>
            </div>
            <div class="form-input">
        		<form:label path="version">Version</form:label>
        		<form:errors path="version"/>
        		<form:textarea path="version" value="${language.version}"/>
            </div>
            <input id=button type="submit" value="Update"/>
         </form:form>
	</div>	
</div>
</body>
</html>