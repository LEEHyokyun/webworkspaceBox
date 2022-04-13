<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkid-fail.jsp</title>
<script type="text/javascript">
	opener.document.getElementById("id").value="";
	opener.document.getElementById("flag").value="";
	opener.document.getElementById("id").focus();

	function closeWindow(){
		self.close();
	}	
</script>
</head>
<!-- 아이디 중복되어 사용 불가 -->
<body>
${param.id }는 중복되어 사용이 불가능합니다.
<br>
<button type="button" onclick="closeWindow()">확인</button>
</body>
</html>