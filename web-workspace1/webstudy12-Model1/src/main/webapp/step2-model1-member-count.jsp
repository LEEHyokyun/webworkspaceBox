<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model1 Architecture</title>
</head>
<body>
<%
	MemberDAO dao = new MemberDAO();
	int count = dao.getAllMemberCount();
%>
<h4>Model 1 Architecture</h4>
회원수 명은 <%=count %>입니다.
</body>
</html>