<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	alert("${param.empno}에 해당하는 사원정보가 존재하지 않습니다.");
	//location.href="find-employee-form.jsp";
	location.href="FindEmployeeFormController.do";
</script>
</body>
</html>