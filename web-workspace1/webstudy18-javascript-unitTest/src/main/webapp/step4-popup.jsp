<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
	<%
		String id = request.getParameter("id");
	%>
	팝업창입니다.
	아이디 : <%=id %>
	<br>
	<button type="button" onclick="closePopup()">확인</button>
<script type="text/javascript">
	function closePopup(){
		//opener.document.getElementById("id").value="";
		//opener.document.getElementById("id").focus();
		opener.document.getElementById("testHidden").value="<%=id%>";
		//id 요소에 접근하여, 중복확인에 따라 본문서 id 부분을 수정한다.
		self.close();
	}
</script>
</body>
</html>