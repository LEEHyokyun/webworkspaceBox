<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward test form</title>
</head>
<body>
<form action="forward-result.jsp">
	<input type="number" name="age" required="required">
	<button type="submit">전송</button>
</form>
</body>
</html>