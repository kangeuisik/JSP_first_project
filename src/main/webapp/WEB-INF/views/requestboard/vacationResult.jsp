<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@include file="../layout/header.jsp" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="jumbotron">
		<h2>승인대기</h2>
	</div>
	<table class="table" >
		<tr>
			<th>신청번호</th>
			<th>소속</th>
			<th>계급</th>
			<th>이름</th>
			<th>군번</th>
			<th>희망기간</th>
			<th>사유</th>
			<th>승인여부</th>
		</tr>
		<c:forEach var="l" items="${resultList }">
		<tr>
			<td> ${l.requestNo }</td>
			<td> ${l.platoon } </td>
			<td> ${l.mrank } </td>
			<td> ${l.name } </td>
			<td> ${l.militaryNo } </td>
			<td> ${l.requestDate } </td>
			<td> ${l.reason } </td>
				<td>
				<a>${l.resultOR }</a>
				 
				</td>
			
		</tr>
		</c:forEach>
	</table>
	<a class="btn btn-primary" href="${contextPath }/requestboard/requestForm">휴가 신청하기</a>
	
</div>

</body>
</html>
<script>
$(function(){

	
})//function

</script>