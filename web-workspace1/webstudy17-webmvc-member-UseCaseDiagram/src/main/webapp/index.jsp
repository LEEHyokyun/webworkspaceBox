<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebMVC 회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
		<h3>WebMVC 회원관리</h3>
		<form action="FindMemberByIdServlet" method="get">
			<input type="text" name="memberId" placeholder="아이디" required="required">
			<button type="submint">회원정보검색</button>
		</form>
	</div>
</body>
</html>