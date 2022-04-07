<%@page import="org.kosta.myproject.model.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
th, td {
	text-align: center;
}
</style>
<title>product-list.jsp</title>
</head>
<body>
	<div class="container pt-4">
		전 상품의 리스트를 조회한 결과는 아래와 같습니다. <br> <br> <a href="index.jsp">Home</a>
		<br>
		<br>
		<table class="table table-bordered table-hover">
			<thead>
				<tr class="bg-primary text-white">
					<th>상품 아이디</th>
					<th>상품명</th>
					<th>등록날짜</th>
				</tr>
			</thead>
			<%
			ArrayList<ProductVO> list = (ArrayList<ProductVO>) request.getAttribute("list");
			%>
			<tbody>
				<%
				for (ProductVO vo:list) {
				%>
				<tr>
					<td><%=vo.getId()%></td>
					<td><a href="FindProductByIdController.do?productId=<%=vo.getId()%>"><%=vo.getName()%></a></td>
					<td><%=vo.getRegDate()%></td>
				</tr>
			</tbody>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>