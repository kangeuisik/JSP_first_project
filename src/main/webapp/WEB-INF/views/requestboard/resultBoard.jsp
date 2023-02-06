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
		<h2>휴가 결재</h2>
	</div>
	<form  action="${contextPath }/requestboard/resultORList" method="post">
		<table class="table">
			<tr>
				<th>신청번호</th>
				<th>소속</th>
				<th>계급</th>
				<th>이름</th>
				<th>군번</th>
				<th>희망기간</th>
				<th>사유</th>
				<th>승인</th>
				<th>반려</th>
			</tr>
			<c:if test="${empty resultORList }">
				<tr>
					<td colspan="6"><b>신청현황이 없습니다.</b></td>
				</tr>
			</c:if>
			<c:if test="${not empty resultORList }">
				<c:forEach var="l" items="${resultORList }">
					<tr>
						<td> ${l.requestNo }</td>
						<td> ${l.platoon } </td>
						<td> ${l.mrank } </td>
						<td> ${l.name } </td>
						<td> ${l.militaryNo } </td>
						<td> ${l.requestDate } </td>
						<td> ${l.reason } </td>
						<div class="">
						<td> 
		 					<input type="checkbox" name="goResult_ck" class="form-control resultGo_ckbox" value="${l.requestNo }">
						</td>
						<td>
		 					<input type="checkbox" name="noResult_ck" class="form-control resultNo_ckbox" value="${l.requestNo }">
		 				</td>
		 				</div>
					</tr>
				</c:forEach>
			</c:if>
		</table>
			<button class="btn btn-primary">결과 전송</button>
	</form>
</div>

</body>

</html>
<script>
$(function(){
	let GoResultSet = new Set(); 
	let NoResultSet = new Set();
	
	//승인
	$('.resultGo_ckbox').on('change',function(){ //셀렉 이벤트
		let goResult = $(this).val(); //위 클래스의 밸류값.
		let checkOn	= $(this).prop('checked'); //
			if(checkOn){//승인을 체크하면
				GoResultSet.add(goResult+'체크');
				$(this).closest('tr').find('.resultNo_ckbox')
					.prop("checked",false).prop("disable",false);
			}else{// 다시 체크해제 했다면	
				GoResultSet.delete(goResult);
			 }
		console.log(GoResultSet);
	})//resultGo
	
	//반려
	$('.resultNo_ckbox').on('change',function(){
		let noResult = $(this).val(); //위 클래스의 밸류값.
		let checkOn	= $(this).prop('checked'); //
			if(checkOn){
				NoResultSet.add(noResult+'체크');
				$(this).closest('tr').find('.resultGo_ckbox')
					.prop("checked",false).prop("disable",false);
			}else{
				NoResultSet.delete(noResult);
			}
		console.log(NoResultSet);
	})//resultNo
		

 	
})//function


</script>