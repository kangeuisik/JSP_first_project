<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="${contextPath }/resources/js/adminboard/list.js">

</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container my-3">
	<form id="listForm">
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list }" var="b">
				<tr>
					<td>
					${b.abno }
					</td>
					<td>
						<a href="${b.abno}" class="title">${b.title } </a>
					</td>
					<td>${b.writer }</td>
					<td>${b.writeDate }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</div>
<a href="${contextPath }/adminboard/writeForm" class="btn btn-primary">글 작성</a>
</body>
</html>