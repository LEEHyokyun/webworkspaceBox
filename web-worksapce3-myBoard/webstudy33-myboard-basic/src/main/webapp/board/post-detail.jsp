<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 상세 게시글 보기 --%>
<table class="table">
	<tr>
		<td>${requestScope.pvo.no }</td>
		<td>${requestScope.pvo.title }</td>
		<td>${requestScope.pvo.memberVO.name }</td>
		<td>${requestScope.pvo.hits }</td>
		<td>${requestScope.pvo.timePosted }</td>
	</tr>
	<%-- sessionScope --%>
	<tr>
		<td colspan="5">
		<pre><font size="4">${requestScope.pvo.content }</font></pre>
		</td>
		<%-- html pre tag, db에 저장된 글 형식 그대로 표현, 행 변경업싱 한 라인상 기술 --%>
		<%-- db에 저장된 글의 내용, 형태를 모두 그대로 가져온다는 것인지, 아니면 다른 구체적인 조건이 있는지.. --%>
	</tr>
	<c:if test="${requestScope.pvo.memberVO.id == sessionScope.mvo.id }">
	<tr>
		<td colspan="5" class="text-center">
			<button type="button">삭제</button>
			<button type="button">수정</button>
		</td>
		<%-- 작성자가 로그인한 자신이라면, 이 영역에 삭제와 수정 기능 제공 
			variable comparison : 게시글 작성자 아이디 = session 작성자 아이디
			button -> button type, 삭제 or 수정 
		--%>
	</tr>
	</c:if>
</table>