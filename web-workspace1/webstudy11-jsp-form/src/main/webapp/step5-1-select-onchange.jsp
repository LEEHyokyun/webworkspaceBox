<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>onchange</title>
</head>
<body>
<script type="text/javascript">
	function sendLine(){
		if(document.getElementById("line").value!="")
			//javascript 제어를 위한 id값을 selector에 추가한다.
		document.getElementById("subwayForm").submit();
	}
	//DOM이 존재하기 때문에 javascript를 통한 제어 가능!
</script>
<!-- onchange event를 활용한 select tag 기능 추가 구성 -->
<form action="step5-2-select-action.jsp" onchange="sendLine()" id="subwayForm">
	<select id="line" name="line" required="required">
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
</form>
</body>
</html>