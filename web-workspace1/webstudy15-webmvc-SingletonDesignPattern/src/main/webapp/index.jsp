<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webmvc</title>
</head>
<body>
<h4>Web MVC</h4>
<%--
	index.jsp -- FindProductByIdServlet -- ProductDAO -- DB
						<forward>           <findProductById(id)> : ProductVO
			  findbyid-success / findbyid-fail
 --%>
<form action="FindProductByIdServlet" method="get">
	<input type="number" name="productId" placeholder="상품아이디" required="required" min="1">
	<button type="submit">검색하기</button>
</form>
<br><br>
<%--
	index.jsp -- 	AllProductListServlet -- PrdouctDAO -- DB
						<forward>     <getAllProductList(): ArrayList<ProductVO>
					product-list.jsp
--%>
<a href="AllProductListServlet">전체상품목록</a>
<br><br>
<%--
	index.jsp -- RegisterProductServlet -- ProductDAO -- DB
				  <doPost(), redirect()>    register(ProductVO)
				  register-result.jsp
 --%>
<form action="RegisterProductServlet" method="post">
	<input type="text" name="name" placeholder="상품명" required="required"><br>
	<input type="text" name="maker" placeholder="제조사" required="required"><br>
	<input type="number" name="price" placeholder="가격" required="required" min="1"><br>
	<button type="submit">상품등록하기</button>
</form>
</body>
</html>