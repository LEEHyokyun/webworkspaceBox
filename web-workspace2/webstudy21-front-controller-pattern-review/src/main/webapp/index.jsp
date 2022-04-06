<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>FrontController Design Pattern review</h3>
<form action="FindCustomerController.do" method="get">
	<input type="text" name="customerId" placeholder="고객아이디" required="required">
	<button type="submit">검색</button>
</form>
<br><br>
<a href="FindAllCustomerListController.do">리스트 조회</a>
<br><br>
<form action="RegisterCustomerController.do" method="post">
	<input type="text" name="customerInfo" placeholder="고객정보" required="required">
	<button type="submit">등록</button>
</form>
<br><br>
<img src="images/Thumbnail.png" alt="webmvc">
<!-- alt : 이미지 로딩이 안되었을때 -->
</body>
</html>