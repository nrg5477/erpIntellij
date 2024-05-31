<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("test");
		$("#noajaxbtn").on("click", function() {
			//동기통신 -> location.href에 컨트롤러 연결
			location.href = "/erp/ajax/noajax?id="+$("#id").val();
		})
		$("#ajaxbtn").on("click", function() {
			//비동기 통신 -> jQuery의 ajax함수를 이용해서 요청
			let querydata = {"id":$("#id").val(), "pass":"1234"};
			//               ----   -------------
			//               name        value
			$.ajax({ //비동기방식으로
				url:"/erp/ajax/ajaxtest01", //주소 요청하면서 (컨트롤러에게)
				type:"get", 
				data:querydata,
				//datatype
				success : success_run, //전송성공시 실행
				error : error_run //실패시 실행
			})
		})
		$("#guguajaxbtn").on("click", function() {
			let dan = {"dan":$("#dan").val()}
			$.ajax({
				url:"/erp/ajax/gugu",
				type:"get",
				data:dan,
				success : print_gugu,
				error : error_run
			})
		})
	})//end ready
	//ajax요청이 성공하면 success_run 호출 -> 실행결과를 success_run의 매개변수로 전달
	function success_run(result) {
		alert("요청성공"+result)
		$("#result2").html("<h2>jquery"+result+"</h2>")
	}
	//ajax요청이 실패하면 error_run 호출 -> 마찬가지로 실행결과를 매개변수로 전달
	//obj - XMLHttpRequest객체
	//msg - 응답메시지
	//statusMsg - 에러메시지
	function error_run(obj, msg, statusMsg) {
		alert("요청실패"+obj+","+msg+","+statusMsg)	
	}
	
	function print_gugu(result) {
		$("#guguresult").html("<h2>gugu:"+result+"</h2>")
	}
</script>
</head>
<body>
	<h3>Ajax테스트하기</h3>
	<form name="myform" action="" >
		<input type="text" name="id" id="id"/>
		<input type="text" name="name" id="name"/>
		<input type="button" value="no ajax테스트" id="noajaxbtn"/>
		<input type="button" value="ajax테스트" id="ajaxbtn"/>
	</form>
	<!-- 동기통신의 실행결과는 EL로 표현 -->
	<div id="result">${msg }</div>
	<!-- 비동기통신의 실행결과는 success_run함수에서 자바스크립트로 생성 -->
	<div id="result2"></div>
	
	<h3>구구단출력하기</h3>
	<form name="myform">
		<input type="text" name="id" id="dan"/>
		<input type="button" id="guguajaxbtn" value="구구단출력">
	</form>
	<div id="guguresult"></div>
</body>
</html>