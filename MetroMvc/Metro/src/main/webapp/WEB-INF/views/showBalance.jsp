<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${message }</h2>
<core:if test="${empty StartingStation }">
<a href="./menu">Go Back to menu</a>
</core:if>
<core:if test="${not empty StartingStation }">>
<a href="./checkInDisplay">Go Back</a>
</core:if>
</body>
</html>