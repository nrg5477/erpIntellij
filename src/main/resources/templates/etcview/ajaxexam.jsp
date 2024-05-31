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
		$("#testbtn").on("click", function() {
			let querydata = {"boardno":$("#boardno").val()}
			$.ajax({
				url:"/erp/ajax/exam01",
				type:"get",
				data:querydata,
				success : print_result,
				error : error_run
			})
		})
	})
	$(document).ready(function() {
	    $("#testjsonbtn").on("click", function() {
	        $.ajax({
	            url:"/erp/ajax/exam02",
	            type:"get",
	            success : print_arr_result,
	            error : error_run
        	})
    	})
	})
	function print_result(result) {
		$("#no").text(result.board_no);
	    $("#title").text(result.title);
	    $("#writer").text(result.id);
	    $("#content").text(result.content);
	}
	function print_arr_result(result) {
	    // 결과 배열을 순회하며 각 항목을 처리
	    let printArrHTML = "<ul>";
	    result.forEach(function(board) {
	        printArrHTML += "<li>";
	        printArrHTML += "<h4>글번호: " + board.board_no + "</h4>";
	        printArrHTML += "<h4>제목: " + board.title + "</h4>";
	        printArrHTML += "<h4>작성자: " + board.id + "</h4>";
	        printArrHTML += "<h4>내용: " + board.content + "</h4>";
	        printArrHTML += "</li>";
	    });
	    printArrHTML += "</ul>";

	    // 결과를 출력할 요소에 HTML 추가
	    $("#printarr").html(printArrHTML);
	}
	function error_run(obj, msg, statusMsg) {
		alert("요청실패"+obj+","+msg+","+statusMsg)	
	}
</script>
</head>
<body>
	<form>
		글번호:<input type="text" name="boardno" id="boardno"/>
		<input type="button" value="ajax_jsonobj" id="testbtn"/>
		<input type="button" value="ajax_jsonarr" id="testjsonbtn"/>
	</form>
	<div id="result">
		<h4>글번호:<span id="no"></span></h4>
		<h4>제목:<span id="title"></span></h4>
		<h4>작성자:<span id="writer"></span></h4>
		<h4>내용:<span id="content"></span></h4>
	</div>
	<div id="printarr">
	
	</div>
</body>
</html>