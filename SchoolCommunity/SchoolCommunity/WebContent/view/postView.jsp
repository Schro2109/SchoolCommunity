<%@page import="com.vo.PostReplyVO"%>
<%@page import="com.vo.PostCommentVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vo.PostContentsVO"%>
<%@page import="com.dao.SchoolDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int pCode = Integer.parseInt(request.getParameter("pCode"));
out.print(pCode);
SchoolDAO dao = new SchoolDAO();
PostContentsVO vo = dao.getPostContents(pCode);
ArrayList<PostCommentVO> list = dao.getPostComments(pCode);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분경 학생마당</title>
<link rel="stylesheet" href="../intro/style.css">
</head>
<body>
	<div class="container">
		<%@ include file="../intro/header.jsp"%>
		<div class="con">
			<div class="item">
				<%=vo.getpType()%>
				<%=vo.getTitle()%>
				<%=vo.getName()%>
				<%=vo.getContents()%>
				<%
					for (PostCommentVO cvo : list) {
				%>
				<ul><%=cvo.getCmCode()%><%=cvo.getContents()%><%=cvo.getName()%>
					<%
						ArrayList<PostReplyVO> rList = dao.getPostReply(cvo.getCmCode());
						for(PostReplyVO rvo : rList){%>
							<li><%=rvo.getReCode()%><%=rvo.getContents()%><%=rvo.getName()%></li>		
						<%}
					%>
					
				</ul>
				<%
					}
				%>
			</div>
			<%@ include file="../intro/aside.jsp"%>
		</div>
		<%@include file="../intro/footer.jsp"%>
	</div>
</body>
</html>