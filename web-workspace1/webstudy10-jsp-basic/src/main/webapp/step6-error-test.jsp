<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="step6-error.jsp"%>
 <%-- 지시자 태그안에 errorPage 설정을 하여, error 발생시 지정한 경로를 통해 페이지가 사용자에게 보여진다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error page config</title>
</head>
<body>
<%
	String name="아이유";
	name=null;
%>
이름은 <%=name.length() %>자로 구성되어 있습니다.
</body>
</html>