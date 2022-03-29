<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward & redirect brief</title>
</head>
<body>
<h4>Model2 MVC forward/redirect</h4>
<%--
	index.jsp -> RedirectServlet -->(redirect) --> redirect-result.jsp
 --%>
<ul>
	<li><a href="ForwardServlet">forward</a></li>
	<li><a href="RedirectServlet">redirect</a></li>
</ul>
<image src="images/forward-redirect-이동방식.png">
</body>
</html>