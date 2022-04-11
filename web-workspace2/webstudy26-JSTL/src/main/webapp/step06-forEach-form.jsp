<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foreach / form</title>
</head>
<body>
<% 
	String menu[] = {"치킨", "피자", "샐러드"};
	request.setAttribute("menuArray", menu);
%>
<form action="step06-forEach-result.jsp" onsubmit="return checkForm()">
	<c:forEach items="${requestScope.menuArray }" var="menu">
	<input type="checkbox" name="menu" value="${menu }">${menu }<br>
	</c:forEach>
	<button type="submit">주문</button>
</form>
<script type="text/javascript">
	function checkForm(){
		let flag = false;
		let menuList = document.getElementsByName("menu");
		
		for(let i=0;i<menuList.length;i++){
			if(menuList[i].checked){
				flag = true;
				break;
			}
		}
		if(flag == false)
			alert("메뉴를 선택하세요");
		return flag;
	}
</script>
</body>
</html>