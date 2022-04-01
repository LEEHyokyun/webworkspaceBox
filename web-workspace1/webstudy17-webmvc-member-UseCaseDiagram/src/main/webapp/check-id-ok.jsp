<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>check-id-ok.jsp</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	%>
	<script type="text/javascript">
		alert("입력하신 <%=id %>는 사용 가능한 아이디입니다.");
		opener.document.getElementById("checkFlag").value = "<%=id%>";
		self.close();
		<!--별도 button에 onclick 함수를 만들어서 self.close() 하는 것도 가능하다.-->
	</script>
</body>
</html>