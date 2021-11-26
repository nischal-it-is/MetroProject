<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%> 
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<spring:form action="./checkInDisplay" modelAttribute="StationObject">
	<spring:select path="stationId">
		<core:forEach items="${stationlist}" var="station">
			<spring:option value="${station.stationId}" 
			label="${station.stationName}">
			</spring:option>
		</core:forEach>
	</spring:select>
	<input type="submit" value="checkIn">
</spring:form>
</body>
</html>