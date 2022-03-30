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
	
		<h3>WebMVC 회원관리 - 회원정보 검색시 오류가 발생하였습니다.</h3>
		<%
			String id = request.getParameter("memberId");
		%>
		<br><br>
		<%=id %>에 대한 회원정보는 존재하지 않습니다.
		<br><br>
		<a href="index.jsp">Home</a>
	</div>
</body>
</html>