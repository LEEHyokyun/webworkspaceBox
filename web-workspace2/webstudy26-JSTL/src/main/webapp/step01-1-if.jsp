<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL 선언 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL if</title>
</head>
<body>
<c:if test="true">
	jstl if문 동작한다.
</c:if>
<c:if test="false">
	jstl if문 동작하지 않는다.
</c:if>
<a href="step01-2-if.jsp?userName=아이유&userAge=22">step01-02-if.jsp</a>
</body>
</html>