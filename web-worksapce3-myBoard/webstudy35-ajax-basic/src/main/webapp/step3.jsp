<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3 ajax</title>
</head>
<body>
<input type="text" id="id"  placeholder="아이디"><button type="button" onclick="startAjax()">회원조회</button>
<span id="result"></span>
<script type="text/javascript">
	let xhr = new XMLHttpRequest(); //Ajax 통신을 위한 javascript 객체
	function startAjax(){
		let id = document.getElementById("id").value;
		if(id==""){
			alert("아이디를 입력하세요.");
			return; //현재 function 동작을 중단한다.
		}
		
		//익명함수 방식
		/* xhr.onreadystatechange=function(){
			//readyState=4 : 서버로부터 응답받는 작업이 완료된 상태
			//status=200 : 정상수행
			if(xhr.readyState==4&&xhr.status==200){
				//alert(xhr.responseText); //responseText : 서버가 응답한 데이터
				document.getElementById("result").innerHTML = xhr.responseText;
			}
		} */
		
		//callback 함수 등록
		//xhr.onreadystatechange = callback;
		
		//onload를 통한 콜백
		//onload 자체가 readyState=4, status=200임을 이미 전제
		/* xhr.onload = function(){
			//alert("hello ajax world");
			document.getElementById("result").innerHTML = xhr.responseText;
		}
		 */
		 xhr.onload=()=>{
			 alert("hello ajax world");
			 document.getElementById("result").innerHTML = xhr.responseText;
		 }
		xhr.open("get", "AjaxMemberServlet?memberId="+id);
		xhr.send();
	}
	/* function callback(){
		//readyState=4 : 서버로부터 응답받는 작업이 완료된 상태
		//status=200 : 정상수행
		if(xhr.readyState==4&&xhr.status==200){
			//alert(xhr.responseText); //responseText : 서버가 응답한 데이터
			document.getElementById("result").innerHTML = xhr.responseText;
		}
	} */
</script>
</body>
</html>














