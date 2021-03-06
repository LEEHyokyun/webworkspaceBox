<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-bordered table-hover boardlist">
	<tr style="background-color: #d6f5d6">
		<th>글번호</th>
		<th class="title">제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	</thread>
	<tbody>
		<c:forEach items="${requestScope.list }" var="list">
			<tr>
				<td>${list.no }</td>
				<td>
				<c:choose>
				<c:when test="${sessionScope.mvo == null }">
					${list.title }
				</c:when>
				<c:otherwise>
					<a href="PostDetailController.do?no=${list.no }">${list.title }</a>
				</c:otherwise>
				</c:choose>
				</td>
				<td>${list.memberVO.name }</td>
				<td>${list.timePosted }</td>
				<td>${list.hits }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>