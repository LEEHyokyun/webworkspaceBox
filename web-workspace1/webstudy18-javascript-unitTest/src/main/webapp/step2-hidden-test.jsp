<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step2-hidden-test.jsp</title>
</head>
<body>
	<%--
		hidden을 이용한 아이디 중복체크
	 --%>
	 <form action="step2-hidden-test-action.jsp" onsubmit="return checkForm()">
	 	<input type="text" id="memberId" name="id" placeholder="아이디" required="required">
	 	<input type="hidden" id="checkFlag" value="">
	 	<button type="submit">가입</button>
	 </form>
	 <hr>
	 <!--  hidden checkFlag 변경 -->
	 <button type="button" onclick="changeFlag()">hidden값 변경</button>
	 
	 <script type="text/javascript">
	 	//checkFlag가 공란일경우 전송하지 않는다.
	 	function checkForm(){
	 		if(document.getElementById("checkFlag").value != document.getElementById("memberId").value){
	 			alert("아이디 중복확인을 체크하세요");
	 			return false;
	 		}else{
	 			return true;
	 		}
	 	}
		function changeFlag(){
			//사용자가 입력한 아이디 정보를 hidden check flag로 할당
			let mId = document.getElementById("memberId").value;
			if(mId==""){
				alert("아이디를 입력하세요.");
			}else{
				document.getElementById("checkFlag").value=mId;
				alert("hidden checkFlag값 변경");
			}
		}
	 </script>
</body>
</html>