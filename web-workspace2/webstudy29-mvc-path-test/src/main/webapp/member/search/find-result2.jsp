<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find-form.jsp</title>
</head>
<body bgcolor="yellow">
<img alt="404error" src="../images/404error.png">
${pageContext.request.contextPath }<br>
<img alt="404error" src="${pageContext.request.contextPath }/images/404error.png">
<br><br>
${param.id }에 대한 검색결과입니다.
</body>
</html>