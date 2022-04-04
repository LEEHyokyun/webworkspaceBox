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
		<h3>회원가입을 위한 정보를 기재해주세요.</h3>
		<br><br>
		<form action="RegisterMemberServlet" method="post" onsubmit="return checkRegForm()">
			<input type="text" id= "id" name="id" placeholder="아이디" required="required">
			<!--  중복확인, checkFlag 최초 공란 -->
			<input type="hidden" id="checkFlag" value="">
			<button type="button" onclick="checkId()">중복확인</button> 
			<br>
			<input type="password" id="password" name="password" placeholder="비밀번호" required="required"><br>
			<input type="password" id="confirmPassword" placeholder="비밀번호 확인" required="required"><br>
			<input type="text" name="name" placeholder="이름" required="required"><br>
			<input type="text" name="address" placeholder="주소" required="required"><br>
			<button type="submit">가입하기</button>
		</form>
		<script type="text/javascript">
			function checkRegForm(){
				//비밀번호 일치시 제출
				
				if(document.getElementById("password").value != document.getElementById("confirmPassword").value){
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
				if(document.getElementById("id").value != document.getElementById("checkFlag").value){
					alert("아이디 중복체크를 진행하지 않았습니다.");
					return false;
				}
					
					return true;
			}
			
			function checkId(){
				let id = document.getElementById("id").value;
				
				if(id == ""){
					alert("아이디를 입력하세요.");
				}else{
					window.open("CheckIdServlet?id="+id, "mypopup",  "width=250, height=150, top=150");
				}
			}
		</script>
		<%--
			1) 패스워드와 패스워드 확인의 일치여부
			2) 일치시 서버로 전송, 불일치시 alert
				ㄴ 불일치에 대한 로직은 javascript
		 --%>
	</div>
</body>
</html>