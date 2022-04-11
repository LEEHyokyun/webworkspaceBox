<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step06-forEach-result.jsp</title>
</head>
<body>
1. 기존 scriptlet
<br><br>
<%
	String menu[] = request.getParameterValues("menu");
	for(int i=0;i<menu.length;i++){
%>
	<%=menu[i] %>
<%
	}
%>
<br><br>
2. EL, JSTL
${paramValues.menu }
<c:forEach items="${paramValues.menu }" var="m">
	${m }
</c:forEach>
<br><br>
</body>
</html>