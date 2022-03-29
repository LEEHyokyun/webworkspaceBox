<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="lime">
forward result page <br>
<%--
	forward 방식은 기존의 request와 response를 유지, controller에서 누적된 정보를 req에서 확보가능
 --%>
 컨트롤러가 저장한 정보 : <%=request.getAttribute("productInfo") %><br>
</body>
</html>