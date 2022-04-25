<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax(JSON을 이용하여 통신)</title>
</head>
<body>
<button onclick="startAjax()">JSONArrayTest</button>
<script type="text/javascript">
	//callback
	function startAjax(){
		let xhr = new XMLHttpRequest();
		xhr.onload = function(){
			//readyState 4, status 200(=onload)
			//alert(xhr.responseText);
			let menu = JSON.parse(xhr.responseText); //JSON array
			for(let i=0;i<menu.length;i++){
				alert(menu[i]);
			}
			
		}
	//send
		xhr.open("get", "JSONArrayServlet");
		xhr.send();
	}
</script>
</body>
</html>










