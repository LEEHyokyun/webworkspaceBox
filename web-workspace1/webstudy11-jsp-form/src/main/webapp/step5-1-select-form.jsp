<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>select option test</title>
</head>
<body>
<form action="step5-2-select-action.jsp" method="get">
	<select name="line" required="required">
		<!-- 1~9 -->
		<option value="">호선</option>
		<%
		for(int i=0;i<9;i++){
		%>
		<option value=<%=i+1 %>><%=i+1 %>호선</option>
		<%
		}
		%>
	</select>
	<button type="submit">전송</button>
</form>
</body>
</html>