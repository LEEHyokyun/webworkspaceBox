<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register-form.jsp</title>
</head>
<body>
<%-- 가입일시는 시스템 내부적으로 sysdate를 통해 자동 입력 --%>
<form method="post" action="RegisterMemberController.do" onsubmit="return checkForm()">
	<!-- 중복확인 클릭시 request로 입력 id 전달,  -->
	<input type="text" name="id" id="id" placeholder="id" required="required"><button type="button" onclick="checkId()">중복확인</button><br>
	<input type="hidden" id="flag" value=""><br>
	<input type="text" name="password" placeholder="password" required="required"><br>
	<input type="text" name="name" placeholder="name" required="required"><br>
	<input type="text" name="address" placeholder="address" required="required"><br>
	<!-- date type의 placeholder 주의, 아래의 경우 type="text" -->
	<input type="text" name="birthday" placeholder="birthday" required="required" onfocus="(this.type='date')"><br>
	<button type="submit">회원가입</button>
</form>
<script type="text/javascript">
	function checkForm(){
		if(document.getElementById("flag").value != document.getElementById("id").value){
			alert("아이디 중복확인이 필요합니다.");
			return false;
		}else{
			return true;
		}
	}
	
	function checkId(){
		let id = document.getElementById("id").value;
		if(id == ""){
			alert("아이디를 입력하세요.");
		}else{
			window.open("CheckIdController.do?id="+id, "mypopup", "width=300, height=200, top=150, left=500");
		}
		
		
	}
</script>
</body>
</html>