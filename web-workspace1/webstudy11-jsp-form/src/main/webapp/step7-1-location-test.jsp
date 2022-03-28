<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>location</title>
</head>
<body>
<form action="step7-2-action.jsp">
	<input type="text" name="userName" required="required" placeholder="이름"><br>
	<input type="number" name="userAge" required="required" placeholder="나이"><br>
	<button type="submit">입장하기</button>
</form>
<!-- 
	19세 이상 : 아이유님 즐거운 성인영화 관람하세요.
	
	19세 미만 : alert, 미성년이므로 관람불가합니다.
 -->
</body>
</html>