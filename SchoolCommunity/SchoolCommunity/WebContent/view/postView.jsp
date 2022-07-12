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
				<div class="postTitle">
				<%=vo.getpType()%>
					<h2><%=vo.getTitle()%></h2>
					<%=vo.getName()%>
				</div>
				<div class="postContents"><%=vo.getContents()%></div>
				<div class="commentBox">
					<%
						for (PostCommentVO cvo : list) {
					%>
					
					<ul class="comment" style="padding: 10px;"><h5 style="margin:0;"><%=cvo.getName()%></h5>
					<%=cvo.getCmCode()%><%=cvo.getContents()%> - [답글쓰기]
						<%
							ArrayList<PostReplyVO> rList = dao.getPostReply(cvo.getCmCode());
							for (PostReplyVO rvo : rList) {
						%>
						<li style="margin:5px 0"><div>
						<h5 style="margin: 0; padding-left: 20px;"><%=rvo.getName()%></h5>
						└ <%=rvo.getReCode()%><%=rvo.getContents()%>
						</div>
						</li>
						<%
							}
						%>
						<li><input type="text"><button>작성</button></li>
					</ul>
					<br>
					<%
						}
					%>
				</div>
			</div>
			<%@ include file="../intro/aside.jsp"%>
		</div>
		<%@include file="../intro/footer.jsp"%>
	</div>
</body>
</html>
