<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기방식테스트</title>
</head>
<body>
<form>
	<input type="text" name="userInfo">
	<button type="button" onclick="startAjax()">비동기방식테스트</button>
	<span id="resultView"></span>
</form>
<hr>
<textarea rows="50" cols="50"></textarea>
<script type="text/javascript">
	let xhr;
	function startAjax(){
		xhr = new XMLHttpRequest(); //Ajax 통신을 위한 자바스크립트 객체
		//alert(xhr);
		xhr.onreadystatechange=callback; //callback function 등록 : 서버측에서 응답하면 작동될 함수
		xhr.open("get","AsynServlet"); //서버와 통신하기 위한 정보를 할당, 요청방식은 get이고 처리할 서버프로그램 url -> AsynServlet
		xhr.send(); // 서버와 통신을 요청 
	}
	function callback(){
		//readyState 4 - 응답데이터를 받은 상태, status 200 정상수행
		if(xhr.readyState==4&&xhr.status==200){
			alert(xhr.responseText); //responseText : 서버가 응답을 보내준 데이터
			document.getElementById("resultView").innerHTML = xhr.responseText;
		}
	}
</script>
</body>
</html>



