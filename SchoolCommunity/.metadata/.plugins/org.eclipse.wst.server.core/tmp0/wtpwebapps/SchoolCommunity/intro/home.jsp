<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("id") != null) {
	String id = session.getAttribute("id").toString();
	out.print(id);
}
%>
<!DOCTYPE html>
<html>
<head>
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
							<li><a href="#none"><span id="ptype">게시판이름</span><span id="title">글제목sdfsdfsdfsdfsdfsdsdfsdsdfsdsdfsdfsdf</span><span id="writer">작성자라우라우</span><span id="suggestion">999+</span><span id="commentCount">99+</span></a></li>
							<li><a href="#none"><span id="ptype">게시판이름</span><span id="title">글제목</span><span id="writer">작성자라fsdsdfsdf우라우</span><span id="suggestion">999+</span><span id="commentCount">99+</span></a></li>
						</ul>
					</div>
					<div class="free">
						<h3>⭐자유게시판</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li><a href="#none"><span id="ptype">게시판이름</span><span id="title">글제목</span><span id="suggestion">999+</span><span id="commentCount">99+</span></a></li>
						</ul>
					</div>
				</div>
				<div class="bot">
					<div class="news">
						<h3>📢공지사항</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li><a href="#none"><span id="ptype">게시판이름</span><span id="title">글제목</span><span id="suggestion">999+</span><span id="commentCount">99+</span></a></li>
						</ul>
					</div>
					<div class="qna">
						<h3>✋Q&A</h3>
						<a href="#none">더보기 〉</a>
						<hr>
						<ul class="homeBoard">
							<li><a href="#none"><span id="ptype">게시판이름</span><span id="title">글제목</span><span id="suggestion">999+</span><span id="commentCount">99+</span></a></li>
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