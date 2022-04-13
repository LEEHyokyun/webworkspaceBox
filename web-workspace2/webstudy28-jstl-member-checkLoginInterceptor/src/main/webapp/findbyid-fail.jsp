<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findbyid-fail.jsp</title>
</head>
<body>
<script type="text/javascript">
	alert("${param.id} 에 대한 회원정보가 존재하지 않습니다");
	location.href="index.jsp";
</script>
</body>
</html>