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
<img alt="404error" src="../images/404error.png" width="200">
${pageContext.request.contextPath }<br>
<img alt="404error" src="${pageContext.request.contextPath }/images/404error.png">
<br>
<!-- 
	member/find-form.jsp -> FronController -> HandlerMapping -> ... -> find-result.jsp
 -->
<form action="${pageContext.request.contextPath }/FindMemberController.do">
	<input type="text" name="id" placeholder="아이디" required="required">
	<button type="submit"></button>
</form>
</body>
</html>