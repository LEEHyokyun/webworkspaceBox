<%@page import="model.FoodVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step04-1-review.jsp</title>
</head>
<body>
<%
	request.setAttribute("food", new FoodVO("치킨", 1000));
%>
<h4>EL, JSTL</h4>
음식명 : 	${requestScope.food.name }
<br>
가격 : ${requestScope.food.price }
<br>
<%-- <c:if test="${food.price>=10000 }">
	${food.name }의 가격은 ${food.price }원입니다, 만원 이상의 가격.
</c:if>
<c:choose>
	<c:when test="${food.name=='치킨' }">
		회식용 음식
	</c:when>
	<c:when test="${food.name=='백반 }">
		식사용 음식
	</c:when>
	<c:otherwise>
		어느 카테고리에도 속하지 않는 음식입니다.
	</c:otherwise>
</c:choose>
</body> --%>
<a href="step04-2-review.jsp?foodName=${food.name }&price=${food.price }">step-04-2로 이동</a>
</html>