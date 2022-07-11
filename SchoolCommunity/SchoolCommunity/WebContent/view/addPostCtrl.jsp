<%@page import="com.vo.PostVO"%>
<%@page import="com.dao.SchoolDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    PostVO vo = new PostVO();
    vo.setPtype(request.getParameter("pType"));
    vo.setWriter(session.getAttribute("id").toString());
    vo.setTitle(request.getParameter("title"));
    vo.setContents(request.getParameter("contents").replaceAll("\r\n", "<br>"));
    SchoolDAO dao = new SchoolDAO();
    int pcode = dao.addPost(vo);
    if(pcode > 0){
    	response.sendRedirect("postView.jsp?pCode="+pcode);
    }else{
    	%>
    	<script>
    	alert("예기치 않은 오류가 발생했습니다.");
    	</script>
    	<%
    	response.sendRedirect("../intro/home.jsp");
    }
    %>