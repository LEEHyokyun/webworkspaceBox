<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update-form.jsp</title>
</head>
<body>
<c:import url="header.jsp" />
<h3>회원정보수정</h3>
<form action="UpdateMemberController.do" method="post">
	<!-- value, 현재 저장되어있는 MemberVO data -->
	<input type="text" name="id" value="${sessionScope.mvo.id }" readonly="readonly"><br>
	<input type="password" name="password" value="${sessionScope.mvo.password }" required="required"><br>
	<input type="name" name="name" value="${sessionScope.mvo.name }" required="required"><br>
	<input type="text" name="address" value="${sessionScope.mvo.address }" required="required"><br>
	<input type="date" name="birthday" value="${sessionScope.mvo.birthday }" required="required"><br>
	<button type="submit">수정하기</button>
</form>
</body>
</html>