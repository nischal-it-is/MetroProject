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
<spring:form action="./addBalance">
	Enter amount to be added<input name="xyz">
<input type="submit" value="add balance">
</spring:form>
${xyz }
${msg }


<br>
<a href="/homepage.jsp">back to login</a>
</body>
</html>