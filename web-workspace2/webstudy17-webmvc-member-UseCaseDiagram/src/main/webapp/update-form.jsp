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
		<a href="index.jsp">Home</a>
		<%
			MemberVO vo = (MemberVO) session.getAttribute("mvo");
		%>
		<br><br>
		<%-- session을 통한 기존 정보 제공 --%>
		<form action="UpdateMemberServlet" method="post">
			<input type="text" name="memberId" value="a"  required=<%=vo.getId() %> readonly="readonly"><br>
			<input type="password" name="memberPassword" value=<%=vo.getPassword() %>  required="required"><br>
			<input type="text" name="memberName" value=<%=vo.getName() %> required="required"><br>
			<input type="text" name="memberAddress" value=<%=vo.getAddress() %> required="required"><br>
			<button type="submit">수정하기</button>
		</form>
	</div>
</body>
</html>