<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hidden tag test.jsp</title>
</head>
<body>
<form action="step1-hidden-test-action.jsp">
	<!-- hidden type: 사용자 화면에 보이지 않는 요소 -->
	<input type="text" name="userId" placeholder="아이디" required="required">
	<input type="hidden" name="command" value="Register">
	<button>전송테스트1</button>
</form>
<hr>
<form action="step1-hidden-test-action.jsp">
	<input type="text" name="userId" placeholder="아이디" required="required">
	<input type="hidden" name="command" value="Delete">
	<button>전송테스트2</button>
</form>
<hr>
<table border="1">
<!-- 
	한 form에 여러 선택지가 존재할때, 어떤 서비스를 요청하는가
	특정 요소를 제출하고자 할때, 제출번호도 같이 제출하는 겨우
	회원가입시, 아이디 중복확인 여부를 hidden에 저장하여, submit후 value에 저장하여 제출
		ㄴ 이를 기억하였다가 후에 회원가입시 아이디 중복여부를 체크
 -->
	<%
		for(int i=10;i>0;i--){
	%>
	<tr>
		<td><%=i %></td>
		<td>불금</td>
		<td>
			<form action="step1-hidden-test-action2.jsp">
				<input type="hidden" name="no" value=<%=i %>>
				<button type="submit">삭제</button>
			</form>
		</td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>