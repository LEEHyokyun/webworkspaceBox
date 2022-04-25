<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax(JSON을 이용하여 통신)</title>
</head>
<body>
<select id="maker" onchange="findCarInfo()">
<%-- tag element 변화시 발생하는 이벤트 --%>
<option value="">---</option>
<option value="현대">현대</option>
<option value="르노">르노</option>
<option value="기아">기아</option>
</select>
모델 <span id="modelView"></span> 가격 <span id="priceView"></span>
<script type="text/javascript">
	function findCarInfo(){
		let maker = document.getElementById("maker").value;
		if(maker==""){
			//seelct option에서 공란을 선택하였을 경우
			document.getElementById("modelView").innerHTML = "";
			document.getElementById("priceView").innerHTML = "";
			return;	
		}
		
		//alert("변화하면 동작되는지 테스트");
		let xhr=new XMLHttpRequest(); //ajax 통신을 위한 javascript req객체
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				//alert(xhr.responseText);
				//서버가 응답한 정보를 JSON 형식으로 parsing하는 작업이 필요
				let car = JSON.parse(xhr.responseText);
				document.getElementById("modelView").innerHTML = car.model;
				document.getElementById("priceView").innerHTML = car.price;
			}
		}
		xhr.open("get","JSONObjectServlet?maker="+document.getElementById("maker").value);
		xhr.send();
	}
</script>
</body>
</html>










