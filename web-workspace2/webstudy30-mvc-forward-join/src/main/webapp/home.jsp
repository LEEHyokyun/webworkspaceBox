<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
<h3>사원관리</h3>
<br>
현재 사원수는 ${requestScope.totalEmpCount } 입니다.
<br><br>
<a href="EmployeeListController.do">사원리스트 조회하기</a>
</body>
</html>