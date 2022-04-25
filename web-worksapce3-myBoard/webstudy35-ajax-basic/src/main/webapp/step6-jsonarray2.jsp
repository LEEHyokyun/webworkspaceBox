<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax(JSON을 이용하여 통신)</title>
</head>
<body>
<!-- <button onclick="startAjax()">JSONArrayTest</button> -->
<select id="maker" onchange="findCarList()">
tag element 변화시 발생하는 이벤트
<option value="">---</option>
<option value="현대">현대</option>
<option value="르노">르노</option>
<option value="기아">기아</option>
</select>
<br><br>
<table border="1">
	<thead>
		<tr>
			<th>모델명</th><th>가격</th>
		</tr>
	</thead>
	<tbody id="carTbody">
		
	</tbody>
</table>

<script type="text/javascript">
	function findCarList(){
		let carTbody = document.getElementById("carTbody");
		let maker = document.getElementById("maker").value;
		if(maker==""){
			alert("제조사를 선택하세요.");
			return;
		}
		
		let xhr=new XMLHttpRequest();
		xhr.onload = function(){ //callback, 서버가 응답하는 시점에서 동작
			//alert(xhr.responseText);
			let carList = JSON.parse(xhr.responseText);
			let carListInfo = "";
			for(let i=0;i<carList.length;i++){
				//carListInfo, 누적이 되어야 한다.
				carListInfo += "<tr>";
				carListInfo += "<td>"+carList[i].model+"</td>";
				carListInfo += "<td>"+carList[i].price+"</td>";
				carListInfo +="</tr>";
			}
			carTbody.innerHTML = carListInfo;
		}
		xhr.open("get", "JSONArrayServlet2?maker="+maker);
		xhr.send();
	}
</script>
</body>
</html>










