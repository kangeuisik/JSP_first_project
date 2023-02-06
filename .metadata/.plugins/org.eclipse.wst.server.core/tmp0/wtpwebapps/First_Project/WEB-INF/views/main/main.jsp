<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ include file="../layout/header.jsp" %>
    
<style>
.topMenu{width: 10;}

</style>
${auth.id}
${auth.grade}
<div class="row">
	<div class="container topMenu col-8">
	  <h2>이미지 파일</h2>
	  <div class="card">
	    <div class="card-body">
	      <h4 class="card-title">Card title</h4>
	      <p class="card-text">Some example text. Some example text.</p>
	      <a href="#" class="#">제 목</a>
	      <a href="#" class="#">내용내용내용내용내용내용내용내용</a>
	    </div>
	  </div>
	</div>
	<div class="topMenu col-4 ">
		<form action="${contextPath }/main" method="post" class="bg-success navbar-dark mr-4">
			<!-- 세션값이 없을때 -->
			<c:if test="${empty auth }">
			<h2 class="container">로그인하기</h2>
		 		아이디 : <input type="text" name="id" ><br>
				비밀번호 : <input type="password" name="pwd" ><br>
			
				<button class="btn btn-light">로그인</button>	
				<a href="${contextPath }/member/joinForm" class="btn btn-light">회원가입하러가기</a>
			</c:if>
			<!-- 세션값이 있을때 -->
			<c:if test="${not empty auth }">
				<h2 class="container">${auth.id }님 로그인중..</h2>
				<a href="${contextPath }/member/logout" class="btn btn-light">로그아웃하기</a>
				<a href="${contextPath }/member/mypage" class="btn btn-light">회원정보보기</a>
			</c:if>
		</form>
	</div>
</div>

<div class="row">
	<div class="col-8 mt-4"><h1>바로가기</h1></div>
	<div class="col-4 mt-4">
		<ul>
			<nav class="navbar navbar-expand-sm bg-success navbar-dark mr-4">
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