<%@page import="model.PersonVO"%>
<%@page import="model.CarVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step10-set</title>
</head>
<body>
<%
	CarVO carvo = new CarVO("SM6", 200);
	PersonVO personvo = new PersonVO("아이유", 30, carvo);
	session.setAttribute("pvo", personvo);
%>
<br>
이름 : ${sessionScope.pvo.name }<br>
자동차 모델명 : ${sessionScope.pvo.carvo.model }<br>
<%--set을 이용한 저장 --%>
<c:set value="${sessionScope.pvo.carvo }" var="car" />
모델명 : ${car.model }
</body>
</html>