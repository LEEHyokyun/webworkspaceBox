<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- select form에서의 data 받아오기 --%>
	<%--
	1~4호선 : 코레일 2호선
	5~9호선 : 도시철도 8호선
 --%>
	<%
	int line = Integer.parseInt(request.getParameter("line"));
	%>
	<%
	if (line <= 4 && line >= 1) {
	%>
	코레일 <%=line%>호선
	<%
	} else {
	%>
	도시철도 <%=line%>호선
	<%
	}
	%>
</body>
</html>