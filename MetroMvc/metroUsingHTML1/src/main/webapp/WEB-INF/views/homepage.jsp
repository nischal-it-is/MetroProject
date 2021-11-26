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
${!IsCheckedIn }
<c:if test="${IsCheckedIn ==false}">
<a href="./checkIn"> Check in</a>
</c:if>
<c:if test="${IsCheckedIn ==true }">
<a href="./checkOut"> Check Out</a>
</c:if><br><br>
<a href="/addBalancePage"> Add Balance</a><br><br>
<a href=""> Check Balance</a><br><br>
<a href=""> Get Travel Log</a><br><br>


</body>
</html>