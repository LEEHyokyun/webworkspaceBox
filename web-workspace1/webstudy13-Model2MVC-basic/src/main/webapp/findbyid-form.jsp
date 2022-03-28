<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-form</title>
</head>
<body>
<%--
	Model2 회원검색
	client - request - Controller  ------------------ Model(VO/DAO) ------ DB
						FindMemberByIdServlet
						    ↓ (VO/DAO 로직 진행후 view로 이동) 
						findbyid-success.jsp
	client <--- res <---  findbyid-fail.jsp
 --%>
<form method="get" action="FindMemberByIdServlet">
	<input type="text" name="memberId" placeholder="아이디" required="required">
	<button type="submit">검색하기</button>
</form>
</body>
</html>