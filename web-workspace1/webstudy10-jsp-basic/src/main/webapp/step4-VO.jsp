<%@page import="model.FoodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FoodVO vo = new FoodVO("진라면","오뚜기",1100);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VO</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>name</th><th>maker</th>
			</tr>
		</thead>
		<tobdy>
			<tr>
				<td><%=vo.getName() %></td><td><%=vo.getMaker() %></td>
			</tr>
		</tobdy>
	</table>
</body>
</html>