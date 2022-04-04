<%@page import="org.kosta238.webstudy17.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyaddress-result.jsp</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
<%
	
%>
	<div class="container">
		<h3>WebMVC 회원 검색결과입니다.</h3><br>
		<table>
			<thread>
				<tr>
					<th>ID</th>
					<th>NAME</th>
				</tr>
			</thread>
			<tbody>
			<%
				MemberVO vo = (MemberVO) session.getAttribute("mvo");
			
			%>
			<%=vo.getName() %>님의 요청: <br>
			<%
				ArrayList<MemberVO> list = (ArrayList<MemberVO>) request.getAttribute("vo");
				for(int i=0;i<list.size();i++){
			%>
				<tr>
					<td><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getName() %></td>
				</tr>
			<%
				}
			%>
			</tbody>
		</table>
		<br><br><a href="index.jsp">Home</a><br>
	</div>
</body>
</html>