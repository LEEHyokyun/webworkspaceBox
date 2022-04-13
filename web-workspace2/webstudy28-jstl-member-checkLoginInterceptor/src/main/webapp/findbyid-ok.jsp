<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-ok.jsp</title>
</head>
<body>
<c:import url="header.jsp" />
${param.id }에 대한 회원정보가 존재합니다.
<br><br>
검색결과: <br>
아이디: ${requestScope.vo.id }<br>
이름: ${requestScope.vo.name }<br>
주소: ${requestScope.vo.address }<br>
생일: ${requestScope.vo.birthday }<br>
가입일시: ${requestScope.vo.regdate }<br>
</body>
</html>