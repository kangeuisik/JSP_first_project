<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!-- 
<script src="${contextPath }/resources/js/board/eduList.js"></script>
 -->


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
		<form id="listForm">
			<div class="row">
				<h3>평가명단</h3>
				<table class="table">
					<tr>
						<th>번호</th>
						<th>계급</th>
						<th>군번</th>
						<th>이름</th>
						<th>평가</th>
						<th>--</th>
					</tr>
					<c:forEach items="${memberList }" var="m">
					<tr>
						<td>${m.mno }</td>
						<td>${m.platoon }</td>
						<td>${m.mrank }</td>
						<td>${m.militaryNo }</td>
						<td>${m.name }</td>
						<td>
						<a href="${contextPath}/edu/memberEduForm?mno=${m.mno}" class="addRank btn btn-info">
						평가결과 입력하기</a>
						<a href="${m.mno }" class="resultScore btn btn-info">
						수준 확인</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</form>

</div>
</body>
</html>