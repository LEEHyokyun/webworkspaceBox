<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-anonymous-arrow-function</title>
</head>
<body>
<h3>자바스크립트 익명함수(anonymous function)와 화살표함수(arrow function : ECMA6 추가된 함수)</h3>
<br><br>
<script type="text/javascript">
	/* function hello(){
		alert("hello 일반함수");
	}
	hello(); */
	
	//익명함수 객체를 변수에 할당
	/* let hello = function(){
		alert("hello 익명함수");
	}
	hello(); */
	
	//브라우저는 순차적으로 동작, 아래 구문은 동작이 될 수 어
	//alert(document.getElementById("infoDiv")); //null
	//alert(document.getElementById("infoDiv")).innerHTML; //error
	
	//window.onload, 웹페이지 로드 후 발생하는 이벤트
	//웹페이지 정보가 로드 후, 호출되는 이벤트 함수를 hi로 등록
	/* window.onload = hi; 
	function hi(){
		alert(document.getElementById("infoDiv"));
		alert(document.getElementById("infoDiv").innerHTML);
	} */
	
	//익명함수 방식을 통한 infoDiv document 제어
	/* window.onload = function(){
		alert(document.getElementById("infoDiv"));
	} */
	
	//ECMA6 arrow function
	window.onload = () => {
		alert(document.getElementById("infoDiv"));
	}
	
	//step3.jsp의 ajax callback function을 익명함수로 변경
</script>

<br><br>
<div id="infoDiv">
Hello World!
</div>
</body>
</html>















