<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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