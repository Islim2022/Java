<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
    <div id="container">
        <div class="Gold-score">
            <p id="your-gold">
            Your Gold: <c:out value="${gold}"></c:out>
            </p>
        </div>

        <div id="forms">
            <div class="form">
                <h2>Farm</h2>
                <p>(Earns 10 - 20 golds)</p>
                <form action="/process_gold" method="POST">
                <input type="hidden" name="form" value="farm" />
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
            <div class="form">
                <h2>Cave</h2>
                <p>(Earns 10 - 20 golds)</p>
                <form action="/process_gold" method="POST">
                <input type="hidden" name="form" value="cave" />
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
            <div class="form">
                <h2>House</h2>
                <p>(Earns 10 - 20 golds)</p>
                <form action="/process_gold" method="POST">
                <input type="hidden" name="form" value="house" />
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
            <div class="form-">
                <h2>Quest</h2>
                <p>(Earns/takes 0 - 50 golds)</p>
                <form action="/process_gold" method="POST">
                <input type="hidden" name="form" value="casino" />
                <button type="submit" class="btn btn-warning">Find Gold!</button>
                </form>
            </div>
        </div>

        <div id="activities-box">
            <h3>Activities:</h3>
            <div id="activities">
         	<c:forEach  var="activity" items="${activities}">
         		<p>${activity}</p>
         	</c:forEach>
            </div>
        </div>
    </div>
</body>
</html>