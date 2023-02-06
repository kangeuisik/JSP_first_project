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
	<div class="jumbotron">
		<h2>신청란</h2>
	</div>

	<form action="${contextPath }/requestboard/request" method="post">
		<table class="table">
			<tr>
				<th>
					<div class="input-group mb-3">
					    <div class="input-group-prepend">
							<span class="input-group-text">번호</span>
							<input type="text" class="form-control" value="${requestNo}" readonly="readonly">
					    </div>
				
					    <div class="input-group-prepend">
					   		<span class="input-group-text">이름</span>
					    	<input type="text" class="form-control" placeholder="이름" name="name">
					  	</div>
					</div>
				</th>
			</tr>
			<tr>
				<th>
					<div class="input-group mb-3">
					    <div class="input-group-prepend">
							<span class="input-group-text">소속</span>
							<input type="text" class="form-control" placeholder="소속" name="platoon">
					    </div>
				
					    <div class="input-group-prepend">
					   		<span class="input-group-text">이름</span>
					    	<input type="text" class="form-control" placeholder="계급" name="mrank">
					  	</div>
					</div>
				</th>
			</tr>
			<tr>
			<th>
			  <div class="input-group mb-3">
			    <div class="input-group-prepend">
			    	<span class="input-group-text">군번</span>
			   		<input type="text" class="form-control" placeholder="군번 - 포함" name="militaryNo">
			    </div>
			    <div class="input-group-prepend">
			    	<span class="input-group-text">기간</span>
			   		<input type="text" class="form-control" placeholder="희망 기간 및 날짜(yyyy-mm-dd ~ yyyy-mm-dd)" name="requestDate">
			    </div>
			  </div>
			  </th>
			</tr>
			<tr>
			<th>
			  <div class="input-group-prepend">
			  	<div class="input-group-prepend">
			    	<span class="input-group-text">사유</span>
			   		<textarea rows="3" type="text" cols="60" class="form-control" placeholder="사유-ex)병가,포상휴가,정기휴가.." name="reason"></textarea>
			    </div>
			  </div>
			  </th>
			 </tr>
			 <tr>
			<th>
			  <div class="input-group-prepend">
			  	<div class="input-group-prepend">
			    	<span class="input-group-text">현재상태</span>
			   		<input type="text" class="form-control" value="승인대기" name="resultOR" readonly="readonly">
					</ul>
			    </div>
			  </div>
			  </th>
			 </tr>
		  </table>
	  
	  
	 <button class="btn btn-primary mt-3">신청하기</button>
	 <a href="${contextPath }/requestboard/vacationResult" class="btn btn-danger mt-3">신청취소</a>
	</form>

</div>
</body>
</html>