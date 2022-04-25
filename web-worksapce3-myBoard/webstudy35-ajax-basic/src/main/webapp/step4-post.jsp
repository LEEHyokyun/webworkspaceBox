<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step4-post</title>
</head>
<body>
<input type="text" id="message" placeholder="메세지">
<button onclick="startAjax()" type="button">post ajax test</button>
<script type="text/javascript">
	function startAjax(){
		let message = document.getElementById("message").value;
		if(message == ""){
			alert("메시지를 입력하세요.");
			return;
		}
		let xhr=new XMLHttpRequest(); //Ajax 통신을 위한 javascript 객체
		//callback, 서버 응답시 동작
		xhr.onreadystatechange=function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				alert(xhr.responseText);
			}
		}
		xhr.open("post", "AjaxPostServlet"); //post method 
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); //post method, send request
		xhr.send("message="+message); //alert와 함께 console에 출력
	}// startAjax
</script>
</body>
</html>




















