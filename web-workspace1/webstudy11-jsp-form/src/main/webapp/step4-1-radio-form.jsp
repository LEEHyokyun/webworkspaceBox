<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<String> list = new ArrayList<String>();
list.add("비빔밥");
list.add("짜장면");
list.add("햄버거");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>radio form</title>
</head>
<body>
	<form action="step4-2-radio-action.jsp" method="get">
		<%
		for(int i=0;i<list.size();i++){	
			%>
		<input type="radio" name="menu" value="<%=list.get(i)%>"><%=list.get(i) %><br>
		<%
		}
		%>
		<button type="submit">전송</button>
	</form>
</body>
</html>