<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
<h3>client 요청방식을 *.do pattern으로 하는 경우</h3>
<!-- 
	*.do > FronControllerServlet이 처리하도록 설정
 -->
<form action="RegisterCarController.do">
	<button type="submit">검색</button>
</form>
<br><br>
<a href="FindCarController.do"></a>
</body>
</html>