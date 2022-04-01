<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>check-id-fail.jsp</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	%>

	<br>
	<script type="text/javascript">
		alert("<%=id %>가 중복되어 회원가입을 진행할 수 없습니다.");
		opener.document.getElementById("id").value="";
		opener.document.getElementById("id").focus();
		self.close();
	</script>
</body>
</html>