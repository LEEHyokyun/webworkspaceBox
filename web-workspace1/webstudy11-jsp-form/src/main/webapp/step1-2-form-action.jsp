<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	client가 submit한 data를 확보한다.
	jsp는 servlet의 service메소드에 삽입되고 동일시된다는 점을 이용,
	servlet service에서 사용하는 메소드를 사용하여 data를 받아온다.
 --%>
 <%
 	String id = request.getParameter("userId");
 	String name = request.getParameter("userName");
 %>
 고객아이디는 <%=id %> 입니다. <br>
 고객이름은 <%=name %> 입니다. <br>
 <%--
 	tomcat/work에서 생성되는 java class 상에서, _jspService(req, res)내에 위 코드가 삽입
 	따라서 req 객체를 바로 이용가능
  --%>
</body>
<%--
	jsp는 동적 웹페이지를 제공
	틀(template)은 그대로 제공하되, 내용적인 content 부분은 client에서 제공하는 정보에 따라 달라진다.
	= template engine!
--%>
</html>

