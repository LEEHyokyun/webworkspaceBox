<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
MVC 구조 상에서 경로 세부 파악<br>
- form action 경로처리 <br>
- Controller > view > 이동시의 경로처리 <br>
<br>
<a href="${pageContext.request.contextPath }/member/find-form.jsp">member/find-form.jsp로 이동</a>
<a href="${pageContext.request.contextPath }/member/search/find-form2.jsp">member/find-form.jsp로 이동</a>
<a href="${pageContext.request.contextPath }/member/register-form.jsp">member/find-form.jsp로 이동</a>
<a href="${pageContext.request.contextPath }/product/find-form.jsp">product/find-form.jsp로 이동</a>
</body>
</html>