<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step04-2-review.jsp</title>
</head>
<body>
전달받은 음식정보는 아래와 같습니다.<br>
음식명 : ${param.foodName }
<br>
음식가격 : ${param.price }
<c:choose>
	<c:when test="${param.price>100 }">
		고가의 치킨	
	</c:when>
	<c:otherwise>
		저가의 치킨
	</c:otherwise>
</c:choose>
</body>
</html>