<%@page import="java.util.Iterator"%>
<%@page import="model.PersonVO"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step09-forEach-map</title>
</head>
<body>
<%
	LinkedHashMap<String, PersonVO> map = new LinkedHashMap<String, PersonVO>();
	map.put("a", new PersonVO("손흥민", 30));
	map.put("b", new PersonVO("이강인", 24));
	map.put("c", new PersonVO("강하늘", 18));
	session.setAttribute("personMap", map);
%>
1. by scriptlet
<br>
<%
	LinkedHashMap<String, PersonVO> pm = (LinkedHashMap<String, PersonVO>) session.getAttribute("personMap");
	Iterator<String> it = pm.keySet().iterator();
	while(it.hasNext()){
		String key=it.next();
%>
	key : <%=key %> <br>
	values: <%=pm.get(key).getName() %> <br>
<%
	}
%>	
<br><br>
<c:forEach items="${sessionScope.personMap }" var="person">
	key: ${person.key } value: ${person.value.name }
	<br>
</c:forEach>
</body>
</html>