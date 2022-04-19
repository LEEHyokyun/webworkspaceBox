<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-bordered table-hover boardlist">
	<thread>
		<tr style="background-color: #d6f5d6">
			<th>글번호</th><th class="title">제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
		</tr>
	</thread>
	<tbody>
	<c:forEach items="${reqeustScope.list }" var="list">
		<tr>
			<td>${list.no }</td><td>${list.title }</td><td>${list.name }</td><td>${list.timePosted }</td><td>${list.hits }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>