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
        <h2>일정목록</h2>

     <div class="input-group mb-3" style="margin-top:20px;">
          <select  class="form-select-sm btn-primary " id="searhKey" name="searchKey">
            <option>선택하세요</option>
            <option>1월</option>
            <option>2월</option>
            <option>3월</option>
            <option>4월</option>
            <option>5월</option>
            <option>6월</option>
            <option>7월</option>
            <option>8월</option>
            <option>9월</option>
            <option>10월</option>
            <option>11월</option>
            <option>12월</option>
          </select>
          
            <input type="text" class="form-control" placeholder="Search">
            <button class="btn btn-secondary" type="submit">Go</button>
          </div>

        
          <table class="table table-hover ">
          
            <thead class="table-secondary">
              <tr>
                <th>번호</th>
                <th>스케쥴명</th>
                <th>분류</th>
                <th>스케쥴진행날짜</th>
                <th>진행상황</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>부서확장협의</td>
                <td>회의</td>
                <td>2024-04-14</td>
                <td>완료</td>
              </tr>
             <tr>
                <td>2</td>
                <td>부서확장임원발표회</td>
                <td>발표</td>
                <td>2024-05-14</td>
                <td>미완료</td>
              </tr>
              <tr>
                <td>3</td>
                <td>혁신지구 탐방 - 울산</td>
                <td>출장</td>
                <td>2024-06.12</td>
                <td>미완료</td>
              </tr>
            
            
           
            </tbody>
          </table>

 
          <ul class="pagination  justify-content-center">
            <li class="page-item disabled"><a class="page-link" href="#">first</a></li>
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
            <li class="page-item"><a class="page-link" href="#">last</a></li>
          </ul>
       
          <div class="container mt-3" style="text-align:right;">
            <a href="/erp/schedule/insert" class="btn btn-secondary">일정등록</a>
          
          </div>
          
    </div>
</body>
</html>