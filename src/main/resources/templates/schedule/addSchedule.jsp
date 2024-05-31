<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
  <div style="padding-top: 30px">
        <h2>일정등록</h2>
		<form action="/erp/schedule/insert" method="post">
        <table class="table table-hover " style="margin-top: 30px;">
            <colgroup>
                <col width="25%">
                <col width="*">
            </colgroup>
        
            <tbody>
              <tr>
                <td>일정시간</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="date" class="form-control" id="scheduleDay" name="scheduleDay" 
                        placeholder="일정 날짜를 선택하세요" >
                    </div>
                </td>
              </tr>      
              <tr>
                <td>제목</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="title" name="title" 
                        placeholder="제목을 입력하세요" >
                    </div>
                </td>
              </tr>        
              <tr>
                <td>일정분류</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <select name="category" class="form-control">
                        	<option value="">일정을선택하세요</option>
							<option value="회의">회의</option>
							<option value="개인일정">개인일정</option>
							<option value="당일출장">당일출장</option>
							<option value="발표">발표</option>
							<option value="기타">기타</option>
						</select>
                    </div>
                </td>
              </tr>      
               <tr>
                <td>참조인</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="boss" name="boss" 
                        placeholder="일정을 공유할 상사의 id를 한 명만 입력하세요" >
                    </div>
                </td>
              </tr>        
               <tr>
                <td>위치</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <input type="text" class="form-control" id="place" name="place" 
                        placeholder="장소를 입력하세요" >
                    </div>
                </td>
              </tr>        
              <tr>
                <td>상세내용</td>
                <td>
                    <div class="mb-3" style="margin-top:13px;">
                        <textarea rows="5" class="form-control" id="content" name="content" >
                        </textarea>
                    </div>
                </td>
              </tr>        
            </tbody>
          </table>
       
          
          
    
		   	 <div class="container mt-3" style="text-align:right;">
		           
		            <button type="submit" class="btn btn-secondary">등록</button>
		            <button type="button" class="btn btn-secondary">목록</button>
		     </div>
	     </form>
     </div>
     
</body>
</html>