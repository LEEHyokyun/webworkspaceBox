<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect-result</title>
</head>
<body bgcolor="yellow">
	redirect result page입니다.
	 컨트롤러가 저장한 정보 : <%=request.getAttribute("productInfo") %><br>
</body>
</html>