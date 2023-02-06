<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="jumbotron">
		<h1>글작성</h1>	
	</div>
	<form action="${contextPath }/adminboard/write" method="post" enctype="multipart/form-data">
			<div class="form-group">
				제목 : <input type="text" class="form-control" name="title">
			</div>
			<div class="form-group">
				내용 : <textarea rows="10" class="form-control" name="content"></textarea>
			</div>
			<div class="form-group">
				작성자 : <input type="text" class="form-control" name="writer" value="${auth.id }" >
			</div>
			<div class="form-group">
				첨부파일 : <input type="file" class="form-control" name="imageFileName">
			</div>
			<button class="btn btn-primary">글작성하기</button>
	</form>
	<div class="preview"></div>
</div>

</body>
</html>