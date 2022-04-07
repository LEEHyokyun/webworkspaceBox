<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step2-param-2.jsp</title>
</head>
<body>
1. 기존 scriptlet 방식<br>
<%=request.getParameter("command") %>
<br><br>
2. EL 방식<br>
${param.command}<br>
${param.nick}<br>
<br>
<form action="step2-param-3.jsp">
	<input type="text" name="userName" placeholder="이름" required="required"><br>
	<input type="number" name="userAge" placeholder="나이" required="required" min="1"><br>
	<button type="submit">전송</button>
</form>
</body>
</html>