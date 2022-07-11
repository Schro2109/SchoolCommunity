<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<script>
	function check(){
		if(document.getElementById("id").value==""){
			alert("아이디가 입력되지 않았습니다.");
			document.getElementById("id").focus();
			return false;
		}
		if(document.getElementById("pw").value==""){
			alert("비밀번호가 입력되지 않았습니다.");
			document.getElementById("pw").focus();
			return false;
		}	
		return true;
	}
	</script>
<div class="login">
	<h3>로그인</h3>
	<form action="../intro/loginCtrl.jsp" method="post" onsubmit="return check()">
		<div class="loginInput">
			<input type="text" id="id" name="id" placeholder="아이디"><br>
			<input type="password" id="pw" name="pw" placeholder="비밀번호"><br>
		</div>
		<button type="submit">로그인</button>
	</form>
	<div class="account-menu">
		<a href="#none">아이디</a>/<a href="#none">비밀번호 찾기</a>
		<a href="#none" id="register">회원가입</a>
	</div>
</div>