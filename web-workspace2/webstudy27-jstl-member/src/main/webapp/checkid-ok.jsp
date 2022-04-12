<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkid-ok.jsp</title>
</head>
<script type="text/javascript">
	function checkId(){
		opener.document.getElementById("flag").value = "${param.id}";
		self.close();
	}
</script>	
<body>
${param.id }는 중복되지 않는 아이디로 사용 가능합니다.
<br>
<button type="button" onclick="checkId()">확인</button>
</body>
</html>