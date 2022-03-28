<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수를 보여주는 view입니다.</title>
</head>
<body>
<a href="index.jsp">Home으로 돌아가기</a>
<!-- 
	controller에서 이동시킨 req, res 객체를 받는다.
	req에서 회원수 정보를 반환받아 화면으로 제공하도록 구성한다.
 -->
회원 수 <%=request.getAttribute("totalCount") %>명
<br><br>
</body>
</html>