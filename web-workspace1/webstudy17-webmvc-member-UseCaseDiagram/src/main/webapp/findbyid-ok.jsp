<%@page import="org.kosta238.webstudy17.model.MemberVO"%>
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
	<% 
		MemberVO vo = (MemberVO) request.getAttribute("MemberVO");
	%>
	<div class="container">
		<h3>WebMVC 회원관리 - 회원정보가 검색되었습니다.</h3>
		<br><br>
		<a href="index.jsp">Home</a>
		회원 아이디 : <%=vo.getId() %><br>
		회원 이름 : <%=vo.getName() %><br>
		회원 주소 : <%=vo.getAddress() %><br>
	</div>
</body>
</html>