<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br>
<spring:form action="./loginCheck" method="post">
Enter card Id : <spring:input type="int" path="card_id"/><br><br>

<input type="submit" value="login">

</spring:form>
<br>
<br>
<a href="./New user">New user</a>

<span>${msg}</span>
</body>
</html>