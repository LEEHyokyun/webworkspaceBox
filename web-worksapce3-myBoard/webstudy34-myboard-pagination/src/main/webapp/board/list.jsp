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
<%--페이지 처리--%>
<%--핵심은 번호배치 및 페이지에 맞는 table 항목 출력 --%>

<ul class="pagination justify-content-center" style="margin:20px 0">
  <c:if test="${requestScope.pagination.previousPageGroup }">
  <li class="page-item"><a class="page-link" href="ListController.do?pageNo=${requestScope.pagination.startPageOfPageGroup-1 }">Previous</a></li>
  </c:if>
  <c:forEach begin="${requestScope.pagination.startPageOfPageGroup}" end="${requestScope.pagination.endPageOfPageGroup}" var="page">
  	<c:choose>
  		<c:when test="${page==pagination.nowPage }">
  			<!--  현재 페이지에 대해 active 효과부여 -->
  			<li class="page-item active"><a class="page-link" href="ListController.do?pageNo=${page }">${page }</a></li>
  		</c:when>
  		<c:otherwise>
  			<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${page }">${page }</a></li>
  		</c:otherwise>
  	</c:choose>
  	
  </c:forEach>
  <c:if test="${requestScope.pagination.nextPageGroup }">
  <li class="page-item"><a class="page-link" href="ListController.do?pageNo=${requestScope.pagination.endPageOfPageGroup+1 }">Next</a></li>
  </c:if>
</ul>