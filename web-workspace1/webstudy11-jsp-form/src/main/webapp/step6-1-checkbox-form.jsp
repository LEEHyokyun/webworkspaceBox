<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
ArrayList<String> list = new ArrayList<String>();
list.add("비빔밥");
list.add("짜장면");
list.add("햄버거");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkbox form</title>
</head>
<body>
<!-- 
	한개이상 선택해야만 submit
 -->
<script type="text/javascript">
	function checkForm(){
		let menuList = document.getElementsByName("menu");
		let flag = false;
	
		for(let i=0;i<menuList.length;i++){
			if(menuList[i].checked)
				{
				flag = true;
				break;
			}
		}
	
	if(!flag){
		alert("메뉴를 한개이상 선택하세요");
	}
	
	return flag;
}
</script>
<form action="step6-2-checkbox-action.jsp" onsubmit="return checkForm()"> 
<%
	for(int i=0;i<list.size();i++){
%>
	<input type="checkbox" name="menu" value="<%=list.get(i) %>"><%=list.get(i) %><br>
<%
	}
%>	
	<button type="submit">주문하기</button>
</form>
</body>

</html>