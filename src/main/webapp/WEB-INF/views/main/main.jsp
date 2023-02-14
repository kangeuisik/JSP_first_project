<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ include file="../layout/header.jsp" %>
    
<style>
.topMenu{
width: 10;
}

</style>

<div class="row">
	<div class="container topMenu col-8 ml-4 ">
	  <div class="card text-center">
	  <h2>이미지 파일</h2>
	    <div class="card-body">
	      <h4 class="card-title">행사소식 대표글</h4>
	      <p class="card-text">Some example text. Some example text.</p>
	      <a href="#" class="#">제 목</a>
	      <a href="#" class="#">내용내용내용내용내용내용내용내용</a>
	    </div>
	  </div>
	</div>
			<!-- 세션값이 없을때 -->
	<div class="topMenu col-3 ">
		<c:if test="${empty auth }">
			<form action="${contextPath }/member/login" method="post" class="bg-info navbar-dark mr-4">
				<p class="container">로그인하기</p>
		 			<p class="container">아이디 : <input type="text" name="id" ></p>
					<p class="container">비밀번호 : <input type="password" name="pwd" ></p><br>
					<button class="btn btn-light">로그인</button>	
				<a href="${contextPath }/member/joinForm" class="btn btn-light">회원가입하러가기</a>
			</form>
		</c:if>
	<!-- 세션값이 있을때 -->
		<c:if test="${not empty auth }">
			<form class="bg-info navbar-dark mr-4 ">
				<div class="container">
					<a class="container">${auth.id }님 로그인중..</a><br>
					<a href="${contextPath }/member/logout" class="btn btn-light">로그아웃하기</a>
					<a href="${contextPath }/member/mypage" class="btn btn-light">회원정보보기</a>
				</div>
			</form>
		</c:if>
	</div>
</div>

<div class="row">
	<div class="col-8 mt-4 ml-3 ">
	<table class="table-info container">
		<tr class="text-center">
			<th>
				<a href="${contextPath }/board/adminList">
			  		<img src="${contextPath }/resources/images/업무참고바로가기.png" /><br>
			  	</a>
			  		<h5>업무참고</h5>
		  	</th>			
		  	<th>
				<a href="${contextPath }/request/requestForm">
			  		<img src="${contextPath }/resources/images/휴가신청 바로가기 로고.png" /><br>
			  	</a>
			  		<h5>휴가신청하기</h5>
		  	</th>
		   	<th>
				<a href="${contextPath }/request/requestForm">
			  		<img src="${contextPath }/resources/images/훈련수준확인.png" /><br>
			  	</a>
			  		<h5>휴가신청하기</h5>
		  	</th>
		  	<th>
				<a href="${contextPath }/edu/memberEduList">
			  		<img src="${contextPath }/resources/images/회원가입 바로가기.png" /><br>
			  	</a>
			  		<h5>회원가입</h5>
		  	</th>
		   	<th>
				<a href="${contextPath }/board/sergantList">
			  		<img src="${contextPath }/resources/images/게시판 바로가기.png" /><br>
			  	</a>
			  		<h5>병사게시판</h5>
		  	</th>
	  	</tr>
	 </table>
	</div>
	<div class="col-3 mt-4">
		<table class="table container bg-info">
		
		</table>
		<ul>
			<nav class="navbar navbar-expand-sm bg-info navbar-dark mr-3">
		 	 	<form class="form-inline" action="/action_page.php">
				    <input class="form-control mr-sm-2" type="text" placeholder="Search">
				    <button class="btn btn-light" type="submit">검색</button>
		  		</form><br>
		</ul>
			<h4>썸네일</h4>
	</div>
</div>
</body>
</html>