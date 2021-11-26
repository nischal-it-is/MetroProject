<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<spring:form action="./loginCheck" method="post">
	Enter Card-Id : <spring:input path="cardId"/><br><br>
	<input type="submit" value="Login">
</spring:form>
</body>
</html>