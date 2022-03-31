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

	<div class="container">
		<h3>WebMVC 회원관리</h3>
		<a href="index.jsp">Home</a><br>
		회원정보가 아래와 같이 수정되었습니다 : <br><br>
		<%
		MemberVO vo = (MemberVO) session.getAttribute("mvo");
		%>
		아이디 : <%=vo.getId() %><br>
		이름 : <%=vo.getName() %><br>
		주소 : <%=vo.getAddress() %><br>
	</div>
</body>
</html>