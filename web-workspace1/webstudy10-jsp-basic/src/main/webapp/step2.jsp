<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--jsp에서의 life cycle존재, 물론 결국 servlet에 들어가는 코드를 만드는 것으로 그것과 매우 유사한 메소드 형태. --%>
<%-- %! -> 인스턴스 멤버 / % -> service --%>
	<%!
	public void JspInit() {
		System.out.println("JspInit()");
	}
	
	public void jspDestroy(){
		System.out.println("JspDestroy()");
	}
	%>
	<%
	System.out.println("jspService()");
	%>
</body>
</html>