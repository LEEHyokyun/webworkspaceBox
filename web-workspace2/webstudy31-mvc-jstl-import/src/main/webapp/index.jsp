<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--
	index.jsp에서 jsp forward를 이용하여 HomeController.do url 명시
	목적 : index.jsp에서 DB를 조회후, DB data를 활용하여 최종적으로 home.jsp로 화면을 출력한다.
	jsp forward에 따라 <html>, <body> 등 DOM 요소가 필요없다.
 --%>
 <jsp:forward page="HomeController.do"/>