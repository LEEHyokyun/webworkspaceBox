<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <h4>상세사원정보</h4>
  <table class="table table-bordered table-hover">
    <thead>
      <tr class="bg-primary text-white">
        <th>사원번호</th>
        <th>사원명</th>
        <th>월급</th>
        <th>부서번호</th>
        <th>부서명</th>
        <th>근무지</th>
        <th>부서TEL</th>
      </tr>
    </thead>
    <tbody>
	  <tr>
		  <td>${requestScope.evo.empno }</td>
		  <td>${requestScope.evo.ename }</td>
		  <td>${requestScope.evo.sal }</td>
		  <td>${requestScope.evo.departmentVO.deptno }</td>
		  <td>${requestScope.evo.departmentVO.dname }</td>
		  <td>${requestScope.evo.departmentVO.loc }</td>
		  <td>${requestScope.evo.departmentVO.tel }</td>
	  </tr>
    </tbody>
  </table>