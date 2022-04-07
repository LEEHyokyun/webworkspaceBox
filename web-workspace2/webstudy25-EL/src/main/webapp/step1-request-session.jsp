<%@page import="model.FoodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step1-request-session</title>
</head>
<body>
<%
	FoodVO vo = new FoodVO("치킨", 10000);
	request.setAttribute("fvo", vo);
	session.setAttribute("foodVO", new FoodVO("피자", 1500));
%>
<h3>(request)기존 scriptlet을 사용한 data 추출</h3>
<br>
<%
	FoodVO fvo = (FoodVO) request.getAttribute("fvo");
%>
<br>
음식명 : <%=fvo.getName() %>
<br><br>
<h3>EL을 사용하여 request, session 정보를 추출한다.</h3>
<br>
음식명: ${requestScope.fvo.name}
<br>
음식명: ${fvo.name}
<br><br>
<h3>(session)기존 scriptlet을 사용한 data 추출</h3>
<br>
<%
	FoodVO fvo2 = (FoodVO) session.getAttribute("foodVO");
%>
<br>
음식명 : <%=fvo2.getName() %>
<br><br>
<h3>EL을 사용하여 request, session 정보를 추출한다.</h3>
<br>
음식명: ${sessionScope.foodVO.name}
<br>
음식명: ${foodVO.name}
</body>
</html>