<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../intro/asideStyle.css">
<script>
function modalOpen(){
	document.getElementById('writeModal').setAttribute("class","active");
}
function modalClose(){
	document.getElementById('writeModal').removeAttribute("class");
}

</script>
<div class="aside">
	<%
		if (session.getAttribute("id") != null) {
	%>
	<%@ include file="logout.jsp"%>
	<%
		} else {
	%>
	<%@ include file="login.jsp"%>
	<%
		}
	%>
	<a href="#none">
		<div class="write" onclick="modalOpen()">
			<h1>글 작성하기</h1>
		</div>
	</a>
	<div class="schedule">
		<iframe src="http://xn--s39aj90b0nb2xw6xh.kr/"></iframe>
	</div>
</div>
<div id="writeModal">
	<div class="modalContents">
		<h2>카테고리 선택</h2>
		<div class="modalBtn">
		<button type="button" onclick="location.href='../view/addPost.jsp?pType=NEWS'">공지사항</button>
		<button type="button" onclick="location.href='../view/addPost.jsp?pType=FREE'">자유게시판</button>
		<button type="button" onclick="location.href='../view/addPost.jsp?pType=QUES'">Q&A</button>
		</div>
		<div class="close-writeModal" onclick="modalClose()">X 닫기</div>
	</div>
</div>