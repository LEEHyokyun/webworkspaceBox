<%@page import="model.MemberVO"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색결과</title>
</head>
<body>
<%--
	현 jsp에서 DAO의 findMemberById(String id) 메소드 호출
	MemberVO 객체 반환시 회원 존재하는 것으로 판단
	null 반환시 회원 존재하지 않는 것으로 판단
 --%>
<a href="index.jsp">홈으로 돌아가기</a>
<%!
	MemberDAO dao = new MemberDAO();
%>
<%
	String id = request.getParameter("memberId");
	MemberVO vo = dao.findMemberByID(id);
	
	if(vo != null){
%>
<%--client가 전송한 아이디에 대한 회원정보가 존재할 경우 --%>
	회원검색결과<br>
	이름: <%=vo.getName() %><br>
	주소: <%=vo.getAddress() %><br>

<%
	}else{
%>
<%--client가 전송한 아이디에 대한 회원정보가 존재하지 않을 경우 --%>
<script type="text/javascript">
	alert("<%=id %>에 대한 회원정보가 존재하지 않습니다.");
	location.href="index.jsp";
</script>
<%
	}
%>
</body>
</html>