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
.Theader{width:10;}
</style>
</head>
<body>
 <!-- 상단 이미지 -->
 <div class="container">
	<div class="Theader row mt-2">
	  <div class="col-3 ">.col</div>
	  <div class="col-6">행정업무 시스템</div>
	  <div class="col-3 ">.col</div>
	</div>
</div>

	<!--header -->
	<nav class="navbar navbar-expand-sm bg-success navbar-dark">
	  <a class="navbar-brand text-body" href="${contextPath }/main">로고</a>
	  <!-- 메뉴얼 -->    
	  	<li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        소개
	      </a>
	      <div class="dropdown-menu ">
	        <a class="dropdown-item" href="#">부대소개</a>
	        <a class="dropdown-item" href="${contextPath }/board/list">행사소식</a>
	        <a class="dropdown-item" href="#">간부소개</a>
	      </div>
	    </li>
	<!-- 메뉴얼 -->
	    <li class="nav-item dropdown" >
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        간부
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="#">휴가결재</a>
	        <a class="dropdown-item" href="#">훈련수준평가</a>
	        <a class="dropdown-item" href="${contextPath }/board/list">Link 3</a>
	      </div>
	    </li>
	<!-- 메뉴얼 -->    
	  	<li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        병사
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="#">근무표</a>
	        <a class="dropdown-item" href="#">휴가 신청</a>
	        <a class="dropdown-item" href="#">훈련수준</a>
	        <a class="dropdown-item" href="${contextPath }/board/list">이모저모</a>
	      </div>
	    </li>
	<!-- 메뉴얼 -->
	    <li class="nav-item dropdown">
	      <a class="nav-link dropdown-toggle topMenu text-body" href="#" id="navbardrop" data-toggle="dropdown">
	        가족
	      </a>
	      <div class="dropdown-menu ">
	        <a class="dropdown-item" href="#">편지쓰기</a> <!-- 글쓰기 -->
	        <a class="dropdown-item" href="${contextPath }/board/list">이모저모</a>
	        <a class="dropdown-item" href="#">Link 3</a>
	      </div>
	    </li>
	   	<li class="d-flex jusify-content-right">
	      <a class="btn btn-outline-success active text-body"  href="#" >
	        로그인
	      </a>

	    </li>
	  </ul>
	</nav>
<br>
  
<div class="container">
  <h3></h3>
  <p></p>
</div>

</body>
</html>
