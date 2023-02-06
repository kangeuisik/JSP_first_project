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
	<h1>신청란</h1>
</div>
<div>
		<table class="table">
			<tr>
				<th>이름</th>
				<th>군번</th>
				<th>희망기간</th>
				<th>사유</th>
				<th>신청</th>
			</tr>
			<c:forEach var="l" items="${resultList }">
			<tr>
				<th> ${l.requestNo }</th>
				<th> ${l.name } </th>
				<th> ${l.militaryNo } </th>
				<th> ${l.requestDate } </th>
				<th> ${l.reason } </th>
			</tr>
			</c:forEach>
		</table>
</div>
</body>
</html>