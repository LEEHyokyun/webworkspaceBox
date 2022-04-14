<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward-result.jsp</title>
</head>
<body>
${param.age }세
<br>
<c:choose>
	<c:when test="${param.age>18 }">
		<jsp:forward page="adult.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:forward page="child.jsp"/>
	</c:otherwise>
</c:choose>
</body>
</html>