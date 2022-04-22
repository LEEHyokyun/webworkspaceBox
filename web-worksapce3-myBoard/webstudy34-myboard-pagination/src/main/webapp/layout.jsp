<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/myhome.css">
</head>
<title>layout.jsp</title>
</head>
<body>
<div class="container-fluid">
	<%-- row배치 - 수평배치 --%>
	<div class="row">
		<div class="col-sm-8 offset-sm-2" align="right">
			<c:import url="header.jsp"/>
		</div>
	</div>
	<%--header --%>
	<div class="row">
		<div class="col-sm-8 offset-sm-2" align="right">
			<c:import url="${requestScope.url }"/>
		</div>
	</div>
	<%--main --%>
</div>
</body>
</html>