<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkbox action</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<%
		String[] list = request.getParameterValues("menu");//request에 data 내장
	%>
	<table>
		<thead>
			<tr>
				<th>No</th>
				<th>Menu</th>
			</tr>
		</thead>
		<tbody>
			<%
			for(int i=0;i<list.length;i++){
			%>
			<tr>
				<td><%=i+1 %></td>
				<td><%=list[i] %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	
	
</body>
<!-- 
	jsp 코드는 최대한 tag와 별개로!
 -->
</html>