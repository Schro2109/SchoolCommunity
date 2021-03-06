<%@page import="com.dao.SchoolDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sessionId = session.getAttribute("id").toString();
	SchoolDAO ldao = new SchoolDAO();
	String name = ldao.getUserName(sessionId);
%>
<script>
	function logout() {
		if (confirm("로그아웃 하시겠습니까?")) {
			location.href = "../intro/logoutCtrl.jsp";
		}
	}
</script>
<div class="logout">
	<h3>
		<%=name %>님 환영합니다.
	</h3>
	<div class="account">
		<div class="account-menu">
			<h3><%=sessionId%></h3>
			<a href="#none">내 글 보기</a>/<a href="#none">회원정보 수정</a>
		</div>
		<button type="button" onclick="logout()">로그아웃</button>
	</div>
</div>