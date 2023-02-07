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

		<table>
			<tr>
				<th>과목</th>
				<c:forEach items="${subList }" var="s">
					<th>${s.subject }</th>
					${s.mno }
				</c:forEach>
			</tr>
			<tr>
				<th>평가결과</th>
				<td><input type="text" class="form-control" name="scoreRank[0]"></td>
				<td><input type="text" class="form-control" name="scoreRank[1]"></td>
				<td><input type="text" class="form-control" name="scoreRank[2]"></td>
				<td><input type="text" class="form-control" name="scoreRank[3]"></td>
				
			</tr>
		</table>
			<button class="btn btn-info">저장</button>		
	</form>
	</div>
</div>

</body>
</html>