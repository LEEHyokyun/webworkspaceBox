<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>grid offset study</title>
</head>
<body>
	<div class="container pt-3">
		<h4>grid offset test : grid .offset-sm-* class를 이용하면 * 열만큼 오른쪽으로
			이동</h4>
		<div class="row">
			<div class="col-sm-5 bg-success text-light">col sml 5열 영역</div>
			<div class="col-sm-5 offset-sm-2 bg-danger text-light">col sml 5열 영역</div>
		</div>
		<div class="row bg-warning">
		<%-- 3열만큼 오른쪽으로 이동해서 9열 영역만 사용 --%>
			<div class="col-sm-9 offset-sm-3 bg-info text-light">grid offset test</div>
		</div>
		<div class="row bg-warning">
		<%-- 3열만큼 오른쪽으로 이동해서 6열 영역만 사용 --%>
			<div class="col-sm-6 offset-sm-3 bg-info text-light">grid offset test2</div>
		</div>
	</div>

</body>
</html>










