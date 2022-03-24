<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp</title>
</head>
<body>
	<%-- jsp notes --%>
	jsp class를 생성하였습니다.
	<br>
	<br>
	<%
	for (int i = 0; i < 5; i++) {
	%>
	<font color="green" size="5">맥주<%=i %>잔</font>
	<%
	}
	%>
	<%!
	//인스턴스 변수 선언
		int count;
	%>
	접속수: <%= ++count
	%>
	<br><br>
	현재 시간
	<%=new Date().toString()%>
	<%--
		java코드영역(%) - 동작, 스크립틀릿 .. service 메서드에 반영된다.
		html영역 - 화면 인터페이싱
	 --%>
</body>
</html>