<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("id")!=null){
		String id = session.getAttribute("id").toString();
		out.print(id);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분경마당</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<div class="con">
			<div class="item">
				<div class="top">
					<div class="hot">
						<h3>👍인기글</h3><a href="#none">더보기 〉</a>
						<hr>
						게시판이름, 글제목, 추천, 댓글수
					</div>
					<div class="free">
						<h3>⭐자유게시판</h3><a href="#none">더보기 〉</a>
						<hr>
						게시판이름, 글제목, 추천, 댓글수
					</div>	
				</div>
				<div class="bot">
					<div class="news">
						<h3>📢공지사항</h3><a href="#none">더보기 〉</a>
						<hr>
						게시판이름, 글제목, 추천, 댓글수
					</div>
					<div class="qna">
						<h3>✋Q&A</h3><a href="#none">더보기 〉</a>
						<hr>
						게시판이름, 글제목, 추천, 댓글수
					</div>
				</div>
			</div>
			<%@ include file="aside.jsp"%>
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>