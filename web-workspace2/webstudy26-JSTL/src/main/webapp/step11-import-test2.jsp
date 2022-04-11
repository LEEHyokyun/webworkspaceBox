<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step11-import-test2.jsp</title>
</head>
<body bgcolor="yellow">
<c:import url="step11-header.jsp" />
test2의 main 영역입니다. <a href="step11-import-test1.jsp">Home</a>
<br>
<c:import url="step11-footer.jsp" />
</body>
</html>

<!-- 
	페이지 소스보기를 보면, <body>태그안에 <html>이 선언되는 등 완결된 소스구조가 아니다.
	import 대상은 반드시 contents만 import되도록 구성한다.
 -->