<%@page import="model.FoodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step02-choose-when-otherwise</title>
</head>
<body>
<%
	request.setAttribute("fvo", new FoodVO("팟타이", 7000));
%>
<!-- JSTL 다중조건(if-else if-else) -->
<c:choose>
	<c:when test="${fvo.name=='짜장면' }">중국음식인 ${fvo.name }</c:when>
	<c:when test="${fvo.name=='팟타이' }">태국음식인 ${fvo.name }</c:when>
	<c:otherwise>
		<!-- else -->해당사항이 없는 음식입니다.
	</c:otherwise>
</c:choose>
</body>
</html>