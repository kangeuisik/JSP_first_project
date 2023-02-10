<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<div class="jumbotron">
		<h1>평가 결과 입력</h1>	
	</div>
	<div class="container">
	<form action="${contextPath }/edu/rankResult" method="post">
		<input type="hidden" name="mno" value="${mno}">
	<table>	
		<h3>${list[0].platoon} ${list[0].mrank} ${list[0].name} </h3> 
		<h5>군번 : ${list[0].militaryNo}</h5>
	</table>
		<table>
			<tr>
				<th>과목</th>
				<th>사격<input type="hidden" name="subject" value="shot"></th>
				<th>화생방<input type="hidden" name="subject" value="chemical"></th>
				<th>구급법<input type="hidden" name="subject" value="emergency"></th>
				<th>제식<input type="hidden" name="subject" value="rule"></th>
			</tr>
			<tr>
				<th>평가결과</th>
				<td><input type="text" class="form-control" name="scoreRank" value=""></td>
				<td><input type="text" class="form-control" name="scoreRank"></td>
				<td><input type="text" class="form-control" name="scoreRank"></td>
				<td><input type="text" class="form-control" name="scoreRank"></td>			
			</tr>
		</table>
		<button class="btn btn-info">저장</button>		
	</form>
	</div>
</div>

</body>
</html>

