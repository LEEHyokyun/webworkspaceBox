<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session-test3</title>
</head>
<body bgcolor="orange">
<br>session test2 page입니다.<br>
 session id: <%=session.getId() %><br><br>

	<%
		session.invalidate();
	%>
	<br>
	<!-- session 무효화 처리되었습니다: <!-- %=session.getAttribute("memberVO") %--!>   -->
	<br><br>
	<a href="session-test1.jsp">session1으로 이동</a>
	<a href="session-test2.jsp">session2으로 이동</a>
</body>
</html>