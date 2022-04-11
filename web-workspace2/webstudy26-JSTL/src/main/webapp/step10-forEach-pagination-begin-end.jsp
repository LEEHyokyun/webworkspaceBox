<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step10-forEahc-pagination-begin-end</title>
</head>
<body>
<!-- 1부터 5까지 표현 -->
<c:forEach begin="1" end="5" var="page">
	${page }&nbsp;
</c:forEach>
<br><br>
<%
	request.setAttribute("startPage", 11);
	request.setAttribute("endPage", 15);
	request.setAttribute("nowPage", 13);
%>
<c:forEach begin="${startPage }" end="${endPage }" var="page">
	<c:choose>
		<c:when test="${page==nowPage}">${page }</c:when>
		<c:otherwise><a href="">${page }</a></c:otherwise>
	</c:choose>
	
</c:forEach>
</body>
</html>