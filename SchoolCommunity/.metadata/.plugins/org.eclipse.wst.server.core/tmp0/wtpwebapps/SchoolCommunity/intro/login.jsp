<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="login">
	<h3>로그인</h3>
	<form action="../view/loginCtrl.jsp" method="post">
		<input type="text" id="id" name="id" placeholder="아이디"><br>
		<input type="password" id="pw" name="pw" placeholder="비밀번호"><br>
		<button type="submit">로긴</button>
		<a href="#none">비밀번호 찾기→</a><a href="#none">로그인</a>
	</form>
</div>