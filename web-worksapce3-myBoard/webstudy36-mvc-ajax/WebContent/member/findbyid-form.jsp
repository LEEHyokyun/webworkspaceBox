<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- 
		ajax로 회원검색결과를 보여준다 
 --%>
<div class="row">
<div class="col-sm-8 offset-sm-2">
	<input type="text" id="memberId" placeholder="ID"	 required="required"> 
	<input type="button" value="검색"  id="findMemberBtn" onclick="findMemberById()">
	<br><br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>이름</th><th>주소</th>
			</tr>
		</thead>
		<tbody id="memberTbody">
			
		</tbody>
	</table>
	<%--
		ajax 방식으로 통신 (요청/응답)
	 --%>
	<script type="text/javascript">
		function findMemberById(){
			let memberTbody = document.getElementById("memberTbody");
			memberTbody.innerHTML = "";
			let memId = document.getElementById("memberId").value;
			if(memId==""){
				alert("아이디를 입력하세요.");
				return;
			}
		
			let xhr = new XMLHttpRequest();
			xhr.onload = function(){
				let jsonData = JSON.parse(xhr.responseText); //데이터가 여러개라면, json list/array 형식으로 저장 및 이를 parsing하여 받아온다.
				if(jsonData.fail=="true"){
					alert(jsonData.message);
				}else{
					let memInfo = "<tr>";
					memInfo += "<td>"+jsonData.name+"</td>";
					memInfo += "<td>"+jsonData.address+"</td>";
					memInfo += "</tr>";
					memberTbody.innerHTML = memInfo;
				}
			}
			xhr.open("get", "FindMemberByIdController.do?id="+memId);
			xhr.send();
		}
	</script>
</div>
</div>























