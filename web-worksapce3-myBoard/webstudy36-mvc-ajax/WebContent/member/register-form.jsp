<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  

<div class="row">
<div class="col-sm-8 offset-sm-2">
<form action="RegisterMemberController.do" method="post" id="registerForm" onsubmit="return checkRegForm()">
<input type="text" name="id" id="memberId" required="required" placeholder="아이디" onkeyup="checkId()">
<span id="checkResult"></span><br>
<input type="password" name="password" required="required" placeholder="패스워드"><br>
<input type="text" name="name" required="required" placeholder="이름"><br>
<input type="text" name="address" required="required" placeholder="주소"><br>
<input type="submit" value="회원가입">
</form>
<%-- memberId id text 입력양식에 keyup 이벤트를 이용해서 
아이디 중복확인을 ajax 방식으로 처리할 수 있다  --%>
<script type="text/javascript">
	//아이디 사용가능 상태일 경우에만 제출
	let checkIdFlag = false;
	function checkRegForm(){
		if(!checkIdFlag){
			alert("아이디 중복확인이 필요합니다.");
		}else{
			checkIdFlag = true;
		}
		
		return false;
	}
	
	function checkId(){
		//keyup event
		let memberId=document.getElementById("memberId").value;
		let checkResult = document.getElementById("checkResult");
		if(memberId.length<4){
				checkResult.innerHTML = "<font color=pink>아이디는 4자이상 입력하여 주십시오</font>";
		}else{
			//입력한 아이디를 ajax 방식을 통해 서버에 제출
			let xhr = new XMLHttpRequest();
			xhr.onload = function(){
				//alert(xhr.responseText);
				checkIdFlag = false;
				if(xhr.responseText=="ok"){
					//기본적으로 ajax 응답은 1개의 요청에 대해 1개의 응답으로 반응한다.
					//request에는 단 하나의 데이터만 받아올 수 있다.
					checkResult.innerHTML = "<font color=green>사용가능</font>";
					checkIdFlag = true;
				}else{
					checkResult.innerHTML = "<font color=red>사용불가</font>";
				}
			}//callback
			xhr.open("get", "CheckIdController.do?id="+memberId);
			xhr.send();
		}
	}
</script>
</div>
</div>














