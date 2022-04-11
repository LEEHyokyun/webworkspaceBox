<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step05 forEach array</title>
</head>
<body>
<%
	String friends[] = {"손흥민", "황희찬", "이강인"};
	request.setAttribute("fa", friends);
%>
<%--
	jstl forEach : jstl loop
	var : 요소를 지정할 변수
	varStatus : index(0부터), count(1부터) , 각각의 속성
 --%>
 <c:forEach items="${requestScope.fa }" var="friend" varStatus="order">
 ${friend }, ${order.index }, ${order.count }
 </c:forEach>
</body>
</html>