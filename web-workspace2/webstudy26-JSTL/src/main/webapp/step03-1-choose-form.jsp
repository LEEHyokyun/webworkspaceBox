<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step03-1-choose-form.jsp</title>
</head>
<body>
<form action="stpe03-2-choose-form.jsp">
	<input type="text" name="userName" placeholder="이름" required="required">
	<input type="number" name="userAge" placeholder="나이" required="required">
	<button type="submit">전송</button>
</form>
</body>
</html>