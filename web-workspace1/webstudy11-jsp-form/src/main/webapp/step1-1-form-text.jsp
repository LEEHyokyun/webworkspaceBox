<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form-text</title>
</head>
<body>
<%--html form and jsp --%>
<form action="step1-2-form-action.jsp" method=get>
<input type="text" name="userId" placeholder="아이디" 	required="required">
<input type="text" name="userName" placeholder="이름" 	required="required">
<button type="submint">전송하기</button>
<button type="rest">리셋하기</button>
</form>
</body>
</html>