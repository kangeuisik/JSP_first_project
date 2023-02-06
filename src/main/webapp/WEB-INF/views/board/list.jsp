<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="${contextPath }/resources/js/board/list.js">

</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
					${b.bno }
					</td>
					<td>
						<a href="${b.bno}" class="title">${b.title } </a>
					</td>
					<td>${b.writer }</td>
					<td>${b.writeDate }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
<a href="${contextPath }/board/writeForm" class="btn btn-primary">글 작성</a>
</div>
</body>
</html>