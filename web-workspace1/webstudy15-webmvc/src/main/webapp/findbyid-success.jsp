<%@page import="org.kosta.webstudy15.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ProductVO vo = (ProductVO) request.getAttribute("product");
%>
<br>
상품명: <%=vo.getName() %>
<br>
상품가격: <%=vo.getPrice() %>
<br>
상품생산지 : <%=vo.getMaker() %>
</body>
</html>