<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp session test</title>
</head>
<body>
<%--
	web container에 의해, jsp>java 생성 / session 생성코드 삽입(즉, 기본적으로 session객체 생성)
	jsp는 기본적으로 session을 사용할 수 있도록 구성(별도 만들 필요가 없음)
 --%>
session id: <%=session.getId() %><br><br>
ServletConfig: <%=config %><br><br>
ServletContext: <%=application %><br><br>

<%--
	jsp에서의 session 정보 저장 및 활용
 --%>
<%
	session.setAttribute("memberVO", new MemberVO("java", "아이유", "오리"));
%>
<br><br>
session에 회원정보를 할당하였습니다.
<br><br>
<a href="session-test2.jsp">session2에서 확인</a>
<br><br>

</body>
</html>