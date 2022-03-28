<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-fail</title>
</head>
<body>
<%
	String id = request.getParameter("memberId");
%>
<script type="text/javascript">
		alert("<%=id %> 아이디에 대한 회원이 존재하지 않습니다.");
		location.href="index.jsp";
</script>
</body>
</html>