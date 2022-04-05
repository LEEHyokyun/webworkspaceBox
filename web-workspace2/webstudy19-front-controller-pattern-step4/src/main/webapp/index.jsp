<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FrontController Design Pattern-4</title>
</head>
<body>
<h4>Web MVC + FrontController Design</h4>
<h2>Handler Mapping</h2>
<br>
<br><br>
<form action="FrontControllerServlet" method="get">
	<input type="hidden" name="command" value="findCarByNo">
	<input type="number" name="carNo" placeholder="차번호" required="required">
	<button type="submit">검색</button>
</form>
<br><br>
<form action="FrontControllerServlet" method="post">
	<input type="hidden" name="command" value="registerCar">
	<input type="text" name="carInfo" placeholder="차정보" required="required">
	<button type="submit">등록</button>
</form>
<br><br>
<%-- querystring 방식을 통한 command value 전달 --%>
<a href="FrontControllerServlet?command=findAllCarList">전체 차량 리스트</a>
</body>
</html>