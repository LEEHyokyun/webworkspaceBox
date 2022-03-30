<%@page import="model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session data</title>
</head>
<body bgcolor="lime">
<%--
	session-test2.jsp에서는 
	> session에 저장된 회원객체가 존재하지 않으면 회원정보존재X
	> session에 회원객체 존재시 저장된 정보 출력
 --%>
 <br>session test2 page입니다.<br>
 session id: <%=session.getId() %><br><br>
<%
	MemberVO vo = (MemberVO) session.getAttribute("memberVO");
	if(vo==null){
%>
	<br>
	현 세션에서는 회원정보가 존재하지 않습니다.
<%
	}else{
%>
	현 세션에서는 저장된 회원정보를 출력합니다.<br>
	회원이름 : <%=vo.getName() %>
	<br><br>
<%
	}
%>
<a href="session-test1.jsp">session1으로의 이동</a>
<br><br>
<a href="session-test3.jsp">session3으로의 이동</a>
<%-- <%
	HttpSession session = request.getSession();
%> --%>
<br><br>
</body>
</html>