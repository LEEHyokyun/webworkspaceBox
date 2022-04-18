<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>grid study</title>
</head>
<body>
<div class="container pt-5">
grid test
<div class="row">
	<div class="col-sm-6" style="background-color:lavender;">col-sm-6</div>
	<div class="col-sm-6" style="background-color:yellow;">col-sm-6</div>
</div>
<%-- grid ( row ) 를 사용하면 div 가 하나씩 옆으로 배치되게 할 수 있다 ( 화면사이즈가 줄어들면 수직 배치 )  --%>
<div class="row">
	<div class="col-sm-3 bg-primary" >left</div>
	<div class="col-sm-6 bg-warning" >main</div>
	<div class="col-sm-3 bg-success">right</div>
</div>
<%-- div 는 수평으로 꽉차게 표현  --%>
<div class="bg-danger">div test1</div>
<%-- div 추가하면 기존 div 아래에 배치  --%>
<div class="bg-info">div test2</div>
</div>

</body>
</html>










