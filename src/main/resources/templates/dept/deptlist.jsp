<%@page import="com.multi.erp.dept.DeptDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
			<div >
				<h3>부서목록(JSTL)</h3>
				<div style="padding-top: 30px">
					
					<table class="table">
						<thead>
							<tr>
								<th>부서번호</th>
								<th>부서명</th>
								<th>부서생성일</th>
								<th>부서레벨</th>
								<th>부서스텝</th>
								<th>상위부서번호</th>
								<th>업무분류</th>
								<th>관리자</th>
								<th>부서주소</th>
								<th>전화번호</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						<!-- items는 컨트롤러에서 공유한 공유명을 정의하고 이 공유명이 EL에서 사용할 수 있는 객체 -->
							<c:forEach var="dept" items="${deptlist}">
								<tr>
	                                <td><a href="/erp/dept/read.do?deptno=${dept.deptno}&action=READ">${dept.deptno}</a></td>
	                                <td>${dept.deptname}</td>
	                                <td>${dept.deptStartDay}</td>
	                                <td>${dept.deptlevel}</td>
	                                <td>${dept.deptstep}</td>
	                                <td>${dept.deptuppercode}</td>
	                                <td>${dept.job_category}</td>
	                                <td>${dept.mgr_id}</td>
	                                <td>${dept.deptaddr}</td>
	                                <td>${dept.depttel}</td>
	                                <td><a href="/erp/dept/delete.do?deptno=${dept.deptno}">삭제</a></td>
                            	</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			
			</div>
</body>
</html>
