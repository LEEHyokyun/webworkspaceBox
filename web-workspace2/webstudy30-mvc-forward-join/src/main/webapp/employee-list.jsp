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
<title>employee-list.jsp</title>
</head>
<body>
<div class="container">        
  <c:import url="header.jsp" />
  <h4>사원명단</h4>
  <table class="table table-bordered table-hover">
    <thead>
      <tr class="bg-primary text-white">
        <th>사원명</th>
        <th>부서명</th>
        <th>근무지</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.list }" var="evo">
      <tr>
      	<!-- Controller로 link를 연결, 그 Controller에서 detail.jsp로 이동한다. -->
      	<!-- 단순히 param.id가 아닌, DB조회 및 data추출이 필요하므로 Controller로 이동 필요 -->
        <td><a href="FindEmployeeByNoController.do?empno=${evo.empno }">${evo.ename }</a></td>
        <!-- a href는 기본적으로 get method, param정보를 전송하거나 추가하여 url설정이 가능 -->
        <!-- a href post : a href="#" javascript 함수와 연결하여, form 양식을 post로 제출하는 방식으로 가능 -->
        <td>${evo.departmentVO.dname }</td>
        <td>${evo.departmentVO.loc }</td>
      </tr>
	</c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>