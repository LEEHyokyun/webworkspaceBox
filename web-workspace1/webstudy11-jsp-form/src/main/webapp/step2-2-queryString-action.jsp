<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step2-2-queryString</title>
</head>
<body>
<%=request.getParameter("no") %>번 뉴스를 제공합니다.
<%=request.getParameter("category") %>항목의 뉴스를 제공합니다.
</body>
</html>