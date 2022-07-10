<%@page import="com.vo.HomePostsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.SchoolDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SchoolDAO dao = new SchoolDAO();
ArrayList<HomePostsVO> hotPostsList = dao.getHomeHotPosts();
ArrayList<HomePostsVO> newsPostsList = dao.getHomePosts("NEWS");
ArrayList<HomePostsVO> freePostsList = dao.getHomePosts("FREE");
ArrayList<HomePostsVO> quesPostsList = dao.getHomePosts("QUES");
%>
<!DOCTYPE html>
<html>
<head>
<style>


</style>
<meta charset="UTF-8">
<title>분경 학생마당</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="con">
			<div class="item">
				<div class="top">
					<div class="hot">
						<h3>👍인기글</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li class="division"><span id="pType">게시판</span><span
								id="title">제목</span><span id="writer">작성자</span><span
								id="suggestion">추천</span><span id="commentCount">댓글</span></li>
							<%
								for (HomePostsVO vo : hotPostsList) {
							%>
							<li><span id="pType"><%=vo.getpType()%></span><span
								id="title"><a
									href="../view/postView.jsp?pCode=<%=vo.getpCode()%>"><%=vo.getTitle()%></a></span><span
								id="writer"><%=vo.getName()%></span><span id="suggestion"><%=vo.getSuggestion()%></span><span
								id="commentCount"><%=vo.getCommentCount()%></span></li>
							<%
								}
							%>
						</ul>
					</div>
					<div class="free">
						<h3>⭐자유게시판</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li class="division"><span id="pType">게시판</span><span
								id="title">제목</span><span id="writer">작성자</span><span
								id="suggestion">추천</span><span id="commentCount">댓글</span></li>
							<%
								for (HomePostsVO vo : freePostsList) {
							%>
							<li><span id="pType"><%=vo.getpType()%></span><span
								id="title"><a
									href="../view/postView.jsp?pCode=<%=vo.getpCode()%>"><%=vo.getTitle()%></a></span><span
								id="writer"><%=vo.getName()%></span><span id="suggestion"><%=vo.getSuggestion()%></span><span
								id="commentCount"><%=vo.getCommentCount()%></span></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
				<div class="bot">
					<div class="news">
						<h3>📢공지사항</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li class="division"><span id="pType">게시판</span><span
								id="title">제목</span><span id="writer">작성자</span><span
								id="suggestion">추천</span><span id="commentCount">댓글</span></li>
							<%
								for (HomePostsVO vo : newsPostsList) {
							%>
							<li><span id="pType"><%=vo.getpType()%></span><span
								id="title"><a
									href="../view/postView.jsp?pCode=<%=vo.getpCode()%>"><%=vo.getTitle()%></a></span><span
								id="writer"><%=vo.getName()%></span><span id="suggestion"><%=vo.getSuggestion()%></span><span
								id="commentCount"><%=vo.getCommentCount()%></span></li>
							<%
								}
							%>
						</ul>
					</div>
					<div class="qna">
						<h3>✋Q&A</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li class="division"><span id="pType">게시판</span><span
								id="title">제목</span><span id="writer">작성자</span><span
								id="suggestion">추천</span><span id="commentCount">댓글</span></li>
							<%
								for (HomePostsVO vo : quesPostsList) {
							%>
							<li><span id="pType"><%=vo.getpType()%></span><span
								id="title"><a
									href="../view/postView.jsp?pCode=<%=vo.getpCode()%>"><%=vo.getTitle()%></a></span><span
								id="writer"><%=vo.getName()%></span><span id="suggestion"><%=vo.getSuggestion()%></span><span
								id="commentCount"><%=vo.getCommentCount()%></span></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
			<%@ include file="aside.jsp"%>
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>