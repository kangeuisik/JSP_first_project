<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>회원가입</h1>	
	</div>
	
	<form action="${contextPath }/member/join" method="post">
		<div class="form-group">
			아이디 : <input type="text" class="form-control" name="id">
		</div>
		<div class="form-group">
			비밀번호 : <input type="password" class="form-control" name="pwd">
		</div>
		<div class="form-group">
			이름 : <input type="text" class="form-control" name="name">
		</div>
		<div class="form-group">
			주민번호 : <input type="text" class="form-control" name="personNo">
		</div>
		<div class="form-group">
			군번 : <input type="text" class="form-control" name="militaryNo">
		</div>
		<div class="form-group">
			주소 : <input type="text" class="form-control" name="addr">
		</div>
		<div class="form-group">
			이메일 : <input type="text" class="form-control" name="email">
		</div>
		<div class="form-group">
			생년월일 : <input type="text" class="form-control" name="birth">
		</div>
		<button class="btn btn-primary">회원가입하기</button>
	</form>
</div>
</body>
</html>