<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<script src="${contextPath }/resources/js/parentsboard/detail.js">

</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="jumbotron">
		<h1>글상세</h1>
	</div>
	<form id="viewForm" enctype="multipart/form-data">
		<table class="table">
			<tr>
				<th>글 번호</th>
				<td>
					${board.pbno}
					<input type="hidden" name="pbno" value="${board.pbno}">
				</td>
				<th>조회수</th>
				<td>0</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					${board.writer}
				</td>
				<th>작성일</th>
				<td>${board.writeDate }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">
					<input type="text" name="title" class="form-control" value="${board.title}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>내용</th>
					<td colspan="3">
						<textarea rows="10" name="content" class="form-control" readonly="readonly">${board.content }</textarea>
					</td>
				<th>파일첨부</th>
					<td colspan="3">
						<input type="file" name="imageFileName" class="form-control viewMode" >
						<div class="my-2">
						<c:if test="${not empty board.imageFileName}">
							<input type="hidden" name="originFileName" value="${board.imageFileName }">	
						<div class="preview">
							<img class="originImg" src="${contextPath}/fileDownload?no=${board.pbno}&imageFileName=${board.imageFileName}&path=board">
						</div>
					</c:if>
				<c:if test="${empty board.imageFileName}">
					<div class="preview">
						<p>등록된 이미지가 없습니다.</p>
					</div>
				</c:if>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="text-center">
				<c:if test="${auth.id eq board.writer or auth.grade eq '관리자'}">	
					<button type="button" class="btn btn-info toModForm">수정하기</button>
					<button type="button" class="btn btn-secondary remove">삭제</button>
				</c:if>
				<button type="button" class="btn btn-success toList">목록</button>			
			</td>
		</tr>
		<tr class="viewMode">
			<c:if test="${auth.id eq board.writer or auth.grade eq '관리자'}">
			<td colspan="4" class="text-center">
				<button type="button" class="btn btn-info modify">수정</button>
				<button type="button" class="btn btn-secondary backViewMode">취소</button>			
			</td>
			</c:if>
		</tr>
	</table>
	</form>
	
	
	
</div>
</body>
</html>