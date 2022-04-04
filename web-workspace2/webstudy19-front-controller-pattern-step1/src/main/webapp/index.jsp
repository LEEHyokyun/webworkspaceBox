<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FrontController Design Pattern</title>
</head>
<body>
<h4>Web MVC + FrontController Design</h4>
<br><br>
<!-- 
	index - FrontController - DAO - DB
				ㄴ forward > findcar-ok.jsp..
 -->
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
</body>
</html>