<%@page import="org.kosta238.webstudy17.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WebMVC 회원관리</title>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<div class="container">
		<h3>WebMVC 회원관리</h3>
		<form action="FindMemberByIdServlet" method="get">
			<input type="text" name="memberId" placeholder="아이디" required="required">
			<button type="submint">회원정보검색</button>
		</form>
		<br><br>
		<%
			MemberVO vo = (MemberVO) session.getAttribute("mvo");
			if(vo == null){
		%>
		<!-- 로그인 상태가 아닐 경우, 즉 session에 로그인 정보(mvo 객체)가 없을 경우 -->
		<h3>로그인하기</h3>
		<form action="LoginServlet" method="post">
			<input type="text" name="memberId" placeholder="아이디" required="required"><br>
			<input type="password" name="memberPw" placeholder="비밀번호" required="required"><br>
			<button type="submint">로그인</button>
		</form>
		<%
		}else{%>
		<!-- 로그인 상태일 경우, 즉 session에 로그인 정보(mvo 객체)가 있을 경우 -->
		<%=vo.getName() %>님께서 로그인 하셨습니다.<br>
		<!-- <a href="LogoutServlet">로그아웃</a> -->
		<!-- logout시 url을 통한 변경을 피하기위해 post방식으로 구성한다(get이동방식 제거), javascript 이용한다. -->
		<a href="#" onclick="logout()">로그아웃</a>
		<form action="LogoutServlet" method="post" id="LogoutForm"></form>
		<script type="text/javascript">
			function logout(){
				document.getElementById("LogoutForm").submit();
			}
		</script>
		<%
		}
		%>
	</div>
</body>
</html>