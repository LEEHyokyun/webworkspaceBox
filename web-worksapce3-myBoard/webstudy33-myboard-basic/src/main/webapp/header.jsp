<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- header.jsp --%>
<%--
	HomeController > layout.jsp
	비로그인 : 로그인 폼
	로그인 : 홈, 글쓰기, 회원명, 로그아웃 링크
 --%>
 <form method="post" action="LoginController.do">
 	<input type="text" name="id" placeholder="아이디" required="required" size="12">
 	<input type="password" name="password" placeholder="비밀번호" size="12">
 	<button type="submit">로그인</button> 
 </form>
