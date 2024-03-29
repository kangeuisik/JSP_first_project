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
		<h1>평가결과</h1>	
	</div>
		<div class="containeer">	
		<c:if test="${testResult[0].platoon ==null }">
			<div>
				<table>
					<tr>
						<th> <h3>평가결과가 최신화 되지 않았습니다. 관리자에게 문의하세요.</h3>
						</th>
					</tr>
				</table>
			</div>
		</c:if>
		

		<div>
			<table>
				<tr>
			
					<th>
						<div class="input-group mb-3">
						    <div class="input-group-prepend">
								<span class="input-group-text">${testResult[0].platoon }</span>
						    </div>
						    <div class="input-group-prepend">
								<span class="input-group-text">${testResult[0].mrank }</span>
						    </div>
						    <div class="input-group-prepend">
						   		<span class="input-group-text">${testResult[0].name }</span>
						  	</div>
						    <div class="input-group-prepend">
						   		<span class="input-group-text">${testResult[0].militaryNo }</span>
						  	</div>
						</div>
					</th>

				</tr>
			</table>
		</div>

		<div>
		<table class="table">
			<tr>
				<th>평가과목</th>
				<c:forEach items="${testResult }" var="t">
					<th>${t.category.subject =='shot' ? '사격':
						 t.category.subject	=='chemical' ? '화생방':
						 t.category.subject =='rule' ? '제식':
						 t.category.subject =='emergency' ? '구급법':''}
					</th>
				</c:forEach>	
			</tr>
			<tr>
				<th>평가결과</th>
				<c:forEach items="${testResult }" var="t">
					<th>${t.category.scoreRank}</th>
				</c:forEach>
			</tr>
			
		</table>
		</div>
	</div>
		
</div>
</body>
</html>

