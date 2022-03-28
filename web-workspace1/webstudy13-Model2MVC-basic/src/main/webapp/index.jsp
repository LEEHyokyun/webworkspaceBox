<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Model2 MVC index</title>
</head>
<body>
<h3>Model2 MVC의 index</h3>
<%--
	회원수 조회
	index.jsp --> request --> Controller --> Model(DAO) --> DB
									AllMemberControlServlet 
					response <-- View
							 		member-count.jsp
 --%>
<ul>
	<!--  전체 회원수를 조회하기 위해 Controller로 요청한다. -->
	<li><a href="AllMemberCountServlet">전체 회원수 보기</a></li> <!-- 카멜케이스 -->
	<li><a href="findbyid-form.jsp">id를 통한 회원검색</a></li> <!-- 스네이크케이스(-) -->
</ul>
<img src="Model2MVC-1.png" width=400><br>
<img src="Model2MVC-2.png" width=400><br>
</body>
</html>