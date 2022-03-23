<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- context 정보에서 직접 받아온다. -->
<h1>This data is from servlet context</h1>
관리자 이메일 : <%=application.getInitParameter("adminEmail") %> <br><br>
<!-- Servlet1에서 할당한 정보를 받아온다-->
<%=application.getAttribute("nick") %>
<br><br>
<a href="ContextTestServlet1">ContextTestServlet1로 이동합니다.</a>
<h1>about jsp</h1>
<%-- JSP note --%>
<% for(int i=0;i<20;i++){ %>
<h3>hello</h3>
<% } %>
</body>
</html>