<%@page import="com.dao.SchoolDAO"%>
<%@page import="com.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	boolean check = true;
	LoginVO vo = new LoginVO();
	vo.setId(id);
	vo.setPw(pw);
	SchoolDAO dao = new SchoolDAO();
	String login = dao.login(vo);
	if(login!=null){
		session.setAttribute("id", login);
	}else{
		check = false;
	}
%>
<script>
	<%if(check){%>
		window.alert("로그인이 완료되었습니다.");
	<%}else{%>
		window.alert("아이디와 비밀번호를 다시 확인해주세요.");
	<%}%>
	
	location.href=document.referrer;
</script>