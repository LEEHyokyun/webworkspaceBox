<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head> 
<body>
<h3>회원관리</h3>
<br><br>
<form action="FindMemberByIdController.do" method="get">
	<input type="text" name="id" placeholder="id" required="required">
	<button type="submit">검색</button>
</form>
<br><br>
<c:choose>
<c:when test="${sessionScope.mvo==null }">
<form action="LoginController.do" method="post">
	<input type="text" name="id" placeholder="id" required="required"><br>
	<input type="password" name="password" placeholder="password" required="required"><br>
	<button type="submit">로그인</button>
	<br><br>
	<a href="register-form.jsp" method="get">회원가입</a>
	<br>
</form>
</c:when>
<c:otherwise>
${sessionScope.mvo.name }님께서 로그인하셨습니다.<br>
	<!-- <a href="LogoutController.do">로그아웃</a> -->
	<!-- 참고로, spring security에서는 로그인/로그아웃을 post 방식으로만 요청 지원 -->
	<a href="#" onclick="logout()">로그아웃</a>
	<form action="LogoutController.do" method="post" id="logoutForm"></form>
	<script type="text/javascript">
		function logout(){
			document.getElementById("logoutForm").submit();
		}
	</script>
	<br><br>
	<%-- 주소로 회원 검색, no value. --%>
	<form action="FindMemberListByAddressController.do" method="get">
		<input type="text" name="address" required="required" placeholder="주소">
		<button type="submit">검색</button>
	</form>
	<br><br>
	<%-- 회원정보 수정폼 역시 비로그인 상태시 index.jsp로 redirect 로직 추가할것 --%>
	<a href="UpdateMemberFormController.do">회원정보 수정</a>
</c:otherwise>
</c:choose>
</body>
</html>