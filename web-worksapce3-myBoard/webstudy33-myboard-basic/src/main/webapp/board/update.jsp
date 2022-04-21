<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<%--게시글 작성폼 --%>
	<form method="post" action="UpdatePostController.do">
		<table class="table">
			<tr>
				<td>
					<input type="hidden" name="no" value="${requestScope.pvo.no }">
					<input type="text" name="title" value="${requestScope.pvo.title }" placeholder="글제목"
					required="required">
				</td>
			</tr>
			<tr>
				<td><textarea row="10" class="form-control" name="content"
					placeholder="본문내용" required="required">${requestScope.pvo.content }</textarea></td>
			</tr>
		</table>
		<div class="text-center">
			<button type="submit" class="btn btn-success">확인</button>
			<button type="reset" class="btn btn-success">취소</button>
		</div>
	</form>