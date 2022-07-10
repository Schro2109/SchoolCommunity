<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.removeAttribute("id");%>
<script>
	window.onload = function(){
		alert("로그아웃이 완료되었습니다.");
		location.href=document.referrer;
	}
</script>