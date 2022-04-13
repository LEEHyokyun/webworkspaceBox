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
<title>findbyaddress-result.jsp</title>
</head>
<body>
<br>
<div class="container">
	<h3>${sessionScope.mvo.name }님께서 요청하신 ${param.address }주소에 대한 회원정보 검색결과가 존재합니다.</h3>
  <c:import url="header.jsp"></c:import>  
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>생년월일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.list }" var="person">
      <tr>
        <td>${person.id }</td>
        <td>${person.name }</td>
        <td>${person.birthday }</td>
      </tr>
     </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>