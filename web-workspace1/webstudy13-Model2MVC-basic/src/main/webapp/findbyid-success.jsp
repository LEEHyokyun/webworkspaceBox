<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-success</title>
</head>
<body>
<%-- 
	forward, 기존 req를 유지하면서 view로 전달, 이 view는 해당 req 내장 변수를 그대로 전달받는다.
--%>
<%  
	MemberVO vo = (MemberVO) request.getAttribute("info");
%>
<%= request.getParameter("memberId") %>에 대한 회원정보입니다.<br>
이름 : <%=vo.getName() %> <br>
주소 : <%=vo.getAddress() %> <br>
</body>
</html>