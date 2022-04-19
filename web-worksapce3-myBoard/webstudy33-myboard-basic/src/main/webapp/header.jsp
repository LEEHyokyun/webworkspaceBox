<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- header.jsp --%>
<%--
	HomeController > layout.jsp
	비로그인 : 로그인 폼
	로그인 : 홈, 글쓰기, 회원명, 로그아웃 링크
 --%>
 <c:choose>
 	<c:when test="${sessionScope.mvo == null }">
 		 <form method="post" action="LoginController.do">
 		<input type="text" name="id" placeholder="아이디" required="required" size="12">
 		<input type="password" name="password" placeholder="비밀번호" size="12">
 		<button type="submit">로그인</button> 
 		</form>
 	</c:when>
 	<c:otherwise>
 		 <a href="ListController.do">홈</a>
 		<a href="WritePostFormController.do">글쓰기</a>
 		<%-- javscript logout function 호출--%>
 		<a href="javascript:logout()">로그아웃</a>
 		<form id="logoutForm" method="post" action="LogoutController.do"></form>
 		<script type="text/javascript">
 			function logout(){
 				if(confirm("로그아웃 하시겠습니까?")){
 					document.getElementById("logoutForm").submit();
 				}
 			}
 		</script>
 		${sessionScope.mvo.name }님께서 로그인 하셨습니다.
 		<br>
 	</c:otherwise>
</c:choose>
 
