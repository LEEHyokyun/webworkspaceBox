<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
    <%-- jsp에서 기본적으로 session을 생성하지 않도록 설정한다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session-test4</title>
</head>
<body>
<%-- 
	directive 지시자 설정을 통해 session 객체 자동생성을 차단
	session = "false"
--%>
<%-- session=false 설정으로 인해 session이 자동생성되지 않아 session 변수 사용 불가 --%> 
<%-- <%=session %> --%>
session-test4입니다. 이 jsp는 session을 기본 생성하지 않습니다.
<%
	HttpSession session = request.getSession();
%>
<!-- 선언된 session이 없기 때문에 중복생성이 아니므로 생성가능. -->
<br><br>
</body>
</html>