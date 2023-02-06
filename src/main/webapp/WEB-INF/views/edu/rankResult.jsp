<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="${contextPath }/resources/js/board/eduList.js">

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
		<h1>훈련수준 입력 리스트</h1>	
	</div>
	<c:forEach items="${ }" var="e">
		<form id="listForm">
			<div class="row">
				<h3>???</h3>
				<table class="table">
					<tr>
						<th>번호</th>
						<th>계급</th>
						<th>군번</th>
						<th>이름</th>
						<th>평가</th>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
						<a href="" class="addScore btn btn-info">
						평가결과 입력하기</a>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</c:forEach>
</div>
</body>
</html>