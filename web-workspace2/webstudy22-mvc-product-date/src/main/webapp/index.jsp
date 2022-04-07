<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>Web MVC / FrontController Design Pattern</h3>
<br><br>
<form action="FindProductByIdController.do" method="get">
	<input type="number" name="productId" placeholder="상품아이디" required="required">
	<button type="submit">검색</button>
</form>
<br><br>
<form action="RegisterProductController.do" method="post">
	<input type="text" name="name" placeholder="상품명" required="required"><br>
	<input type="text" name="maker" placeholder="제조사" required="required"><br>
	<input type="number" name="price" placeholder="가격" min="1" required="required"><br>
	<button type="submit">등록</button>
</form>
<br><br>
<a href="FindAllProductListController.do">상품 전체 리스트 조회</a>
</body>
</html>