<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step3-2-post-action</title>
</head>
<body>
<%!
	String info = "미성년";
//인스턴스 변수는 heap에 저장되며, 값을 할당한 후에는 계속 유지된다는 것에 유의하도록 하자.
%>
<%
//req body에 내장되어 data 전달, 한글별도처리가 필요.
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("userName");
	int age = Integer.parseInt(request.getParameter("userAge"));
	
	//String info = null;
	
	if(age>19){
		info="성인";
	}else{
		info="미성년";
	}
	
	/*
	if(age>19){
		info="성인";
	}else{
		info="미성년";
	}
	*/
		

%>
이름: <%=name %><br>
나이: <%=info%> <%=age%>세
</body>
</html>