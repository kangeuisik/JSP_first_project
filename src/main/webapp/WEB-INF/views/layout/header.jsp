<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
   <c:set var="auth" value="${sessionScope.auth}"/>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- cdnjs -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>const contextPath = "${contextPath}"
	let auth={
		id : "${auth.id}",
		grade : "${auth.grade}"
};
</script>
<script src="${contextPath}/resources/js/common.js"></script>

<style>
.Theader{height:15;}
.banner{
background:url(${contextPath}/resources/images/banner.png);
height:20;
}
</style>
</head>
<body>
 <!-- 상단 이미지 -->
 <div class="container">
	<div class="Theader row mt-2">
	  <div class="col-3 ">
	  	<img src="${contextPath }/resources/images/태극기.png" />

	  </div>
	  <div class="col-6 bg-outline-info">
	  	<a href="${contextPath }/main">
	  	<img src="${contextPath }/resources/images/jsp로고.png" />
	  	oooo 부대홈페이지
	  	</a>
	  </div>
	  <div class="col-3 ">.col</div>
	</div>
</div>

	<!--header -->
	<nav class="navbar navbar-expand-sm bg-info navbar-dark banner">
	  <a class="navbar-brand text-body" href="${contextPath }/main">
	  로고</a>
	  <!-- 메뉴얼 -->    
	  	<li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        소개
	      </a>
	      <div class="dropdown-menu ">
	        <a class="dropdown-item" href="#">부대소개</a>
	        <a class="dropdown-item" href="${contextPath }/board/noticeList">행사소식</a>
	        <a class="dropdown-item" href="${contextPath }/member/memberInfo">회원정보보기</a>
	      </div>
	    </li>
	<!-- 메뉴얼 -->
	    <li class="nav-item dropdown" >
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        간부
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="${contextPath }/requestboard/resultBoard">휴가결재</a>
	        <a class="dropdown-item" href="${contextPath }/edu/memberEduList">훈련수준평가</a>
	        <a class="dropdown-item" href="${contextPath }/board/adminList">업무참고</a>
	      </div>
	    </li>
	<!-- 메뉴얼 -->    
	  	<li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        병사
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="#">근무표</a>
	        <a class="dropdown-item" href="${contextPath }/requestboard/vacationResult">휴가 신청 및 현황</a>
	        <a class="dropdown-item" href="${contextPath }/edu/memberEduList">훈련수준</a>
	        <a class="dropdown-item" href="${contextPath }/board/sergantList">병사용 게시판</a>
	      </div>
	    </li>
	<!-- 메뉴얼 -->
	    <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        가족
	      </a>
	      <div class="dropdown-menu ">
	        <a class="dropdown-item" href="#">편지쓰기</a> <!-- 글쓰기 -->
	        <a class="dropdown-item" href="${contextPath}/board/parentsList">가족들 게시판</a>
	        <a class="dropdown-item" href="#">Link 3</a>
	      </div>
		</li>
		<c:if test="${empty auth }">
		 <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        로그인하기
	      </a>
			 <div class="dropdown-menu ">
		        <a class="dropdown-item" href="${contextPath }/member/loginForm">로그인</a>
		        <a class="dropdown-item" href="${contextPath }/member/joinForm">회원가입하기</a>
		      </div>
		</li>
		</c:if>


		<c:if test="${not empty auth }">
		 <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop"  data-toggle="dropdown">
	        ${auth.id } 
	        ${auth.grade } 님이 로그인중..
	      </a>
			 <div class="dropdown-menu ">
		        <a class="dropdown-item" href="${contextPath }/member/logout">로그아웃하기</a>
		        <a class="dropdown-item" href="${contextPath }/member/mypage">마이페이지</a>
		      </div>
		</li>
		</c:if>
	  </ul>
	</nav>
<br>
  
<div class="container">
  <h3></h3>
  <p></p>
</div>

</body>
</html>
