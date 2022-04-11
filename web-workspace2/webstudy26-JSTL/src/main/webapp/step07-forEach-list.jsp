<%@page import="model.PersonVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL forEach arrayList</title>
</head>
<body>
<% 
	ArrayList<PersonVO> list = new ArrayList<PersonVO>();
	list.add(new PersonVO("아이유", 30));
	list.add(new PersonVO("이강인", 24));
	list.add(new PersonVO("강하늘", 18));
	
	request.setAttribute("list", list);
%>
<c:forEach items="${list }" var="person">
	${person.name } ${person.age }<br>
</c:forEach>
</body>
</html>