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
	<div class="jumbotron">
		<h2>업무참고 게시판</h2>
	</div>
	<form id="listForm">
		<table class="table">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${admin }" var="a">
				<tr>
					<td>
					${a.bno }
					</td>
					<td>
						<a href="${a.bno}" class="title">${a.title } </a>
					</td>
					<td>${a.writer }</td>
					<td>${a.writeDate }</td>
				</tr>
			</c:forEach>
		</table>
	</form>
<a href="${contextPath }/board/writeForm" class="btn btn-primary">글 작성</a>
</div>
</body>
</html>