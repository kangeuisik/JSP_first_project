<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>회원정보보기</h1>	
	</div>
	
	<div class="container">
		<form>
			<table class="table" width="600" >
				<tr>
					<th>회원번호</th>
					<th>아이디</th>
					<th>소속</th>
					<th>계급</th>
					<th>이름</th>
					<th>주민번호</th>
					<th>군번</th>
					<th>주소</th>
					<th>이메일</th>
					<th>생년월일</th>
					<th>가입일자</th>
					<th>회원등급</th>
				</tr>
				<c:forEach var="m" items="${memberInfo }">
				<tr>
					<td>${m.mno }</td>
					<td>${m.id }</td>
					<td>${m.platoon }</td>
					<td>${m.mrank }</td>
					<td>${m.name }</td>
					<td>${m.personNo }</td>
					<td>${m.militaryNo }</td>
					<td>${m.addr }</td>
					<td>${m.email }</td>
					<td>${m.birth }</td>
					<td>${m.joinDate }</td>
					<td>회원등급</td>
				</tr>
				</c:forEach>
			</table>
		</form>
	</div>	

</div>