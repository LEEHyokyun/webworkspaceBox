<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>location action</title>
</head>

<body>
<%
	String name = request.getParameter("userName");
	int age = Integer.parseInt(request.getParameter("userAge"));
	
	if(age > 19){
%>
	<%=name %>님 즐거운 영화관람 하세요!
<%}else{%>

<script type="text/javascript">
		alert("<%=name%>님께서는 미성년이므로 관람불가합니다.");
		location.href="step7-3-child-view.jsp?name=<%=name%>";
</script>
<%
	}
%>
<%--
	너무 어렵게 생각하지 말것!
	javascript 사용을 위해 script를 사용한것이고, 내부적으로 그대로 alert 함수 사용한것임!
 --%>
</body>
</html>