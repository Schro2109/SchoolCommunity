<%@page import="com.dao.SchoolDAO"%>
<%@page import="com.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	LoginVO vo = new LoginVO();
	vo.setId(id);
	vo.setPw(pw);
	SchoolDAO dao = new SchoolDAO();
	String login = dao.login(vo);
	if(login!=null){
		out.print("로그인 성공");
		session.setAttribute("id", login);
		response.sendRedirect("../intro/home.jsp");
		}else{
		out.print("로그인 실패");
		response.sendRedirect("../intro/home.jsp");
	}
%>