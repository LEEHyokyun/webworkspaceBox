<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup</title>
</head>
<body>
<form>
	<input type="text" name="id" id="id" required="required" placeholder="아이디">
	<button type="button" onclick="openPopup()">팝업 띄우기</button>
	<input type="hidden" id="testHidden" value="">
	<button type="button" onclick="showValue()">히든값확인</button>
</form>
<script type="text/javascript">
	function openPopup(){
		let mId = document.getElementById("id").value;
		window.open("TestPopupServlet?id="+mId, "mypopup", "width=250, height=150, top=150");
	}
	
	function showValue(){
		alert(document.getElementById("testHidden").value);
	}
</script>
</body>
</html>