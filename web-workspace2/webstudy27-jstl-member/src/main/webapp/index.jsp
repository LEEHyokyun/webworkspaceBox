<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head> 
<body>
<h3>회원관리</h3>
<br><br>
<form action="FindMemberByIdController.do" method="get">
	<input type="text" name="id" placeholder="id" required="required">
	<button type="submit">검색</button>
</form>
<br><br>
<c:choose>
<c:when test="${sessionScope.mvo==null }">
<form action="LoginController.do" method="post">
	<input type="text" name="id" placeholder="id" required="required"><br>
	<input type="password" name="password" placeholder="password" required="required"><br>
	<button type="submit">로그인</button>
</form>
</c:when>
<c:otherwise>
${sessionScope.mvo.name }님께서 로그인하셨습니다.<br>
	로그아웃
</c:otherwise>
</c:choose>
</body>
</html>