<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="FindEmployeeByNoController.do">
<input type="number" name="empno" placeholder="사원번호" required="required" min="1">
<button type="submit">검색</button>
</form>

