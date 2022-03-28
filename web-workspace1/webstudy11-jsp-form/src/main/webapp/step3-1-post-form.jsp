<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post form</title>
</head>
<body>
<!-- 
	인스턴스변수 할당시 heap에 적재, 할당시 계속 누적된다.
	직접 바꾸지 않는한 할당정보는 바뀌지 않는다.
 -->
<form action="step3-2-post-action.jsp" method="post">
	<input type="text" name="userName" placeholder="이름" required="required"><br>
	<input type="number" name="userAge" min="1" placeholder="나이" required="required"><br>
	<button type="submit">전송</button>
</form>
<%--
	19세 이상이면 
	
	이름 : 아이유
	나이 : 성인 30세
	
	19세 미만이면
	
	이름 : 강하늘
	나이 : 미성년 17세
 --%>
 <%--
 	인스턴스 변수는 최초 객체 초기화할때 생성된다.
 	따라서 이후 service 요청이 지속된다면, 객체 할당값이 바뀌고(재할당), 이에 따라 default값도 바뀌게 된다.
 	service가 요청이 된다면, 이미 값이 다시 바뀐 값으로 그대로 유지가 된다는 점 유의한다.
 	즉, 객체가 재생성되지 않는한 default값은 최근 업데이트 값으로 유지된다.
 --%>
</body>
</html>