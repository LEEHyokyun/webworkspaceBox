<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>사원관리(layout.jsp를 이용한 view 일괄화)</h3>
<br>
현재 사원수는 ${requestScope.totalEmpCount } 입니다.
<br><br>
<a href="EmployeeListController.do">사원리스트 조회하기</a>
<br><br>
<a href="EmployeeCountGroupByDeptController.do">부서별 사원수</a>
<br><br>
<a href="FindEmployeeFormController.do">사원 검색</a>