<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/find-form.jsp</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/FindProductController.do">
	<input type="text" name="id" placeholder="상품 아이디" required="required">
	<button type="submit">상품검색</button>
</form>
</body>
</html>