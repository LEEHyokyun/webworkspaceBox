<%@page import="model.TestVO"%>
<%@page import="model.FoodVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model.jsp</title>
</head>
<body>
<%
	request.setAttribute("food", new FoodVO("팟타이", 7000));
	request.setAttribute("tvo", new TestVO());
%>
${food.name }
<%--
	실제로는 FoodVO 객체의 getName() 메소드가 실행되어 출력된다.
 --%>
 ${tvo.info } <br>
 ${tvo.money } <br>
 <!-- get/is가 명기되지 않은 data는 추출 불가, 이것은 약속이다. -->
 <!-- ${tvo.message} > 불가, sendMessage -->
</body>
</html>