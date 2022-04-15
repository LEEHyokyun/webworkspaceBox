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
<title>employee-count-dept.jsp</title>
</head>
<body>
<div class="container">        
  <c:import url="header.jsp" />
  <h4>부서별 사원수</h4>
  <table class="table table-bordered table-hover">
    <thead>
      <tr class="bg-primary text-white">
        <th>부서명</th>
        <th>근무지</th>
        <th>사원수</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.list }" var="map">
      <tr>
        <td>${map.dname }</td>
        <td>${map.loc }</td>
        <td>${map.emp_no }</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>