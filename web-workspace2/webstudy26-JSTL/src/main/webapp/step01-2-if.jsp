<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step01-2-if.jsp</title>
</head>
<body>
사용자명 : ${param.userName }
사용자 나이 : ${param.userAge }
<br>
<!-- 조건문을 이용한 로직 작성 -->
<c:if test="${param.userAge>19 }">
	성인
</c:if>
<br>
<c:if test="${param.userAge>19 && param.userName=='아이유' }">
	조건부합
</c:if>
</body>
</html>