<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="aside">
	<%if (session.getAttribute("id") != null) {%>
	<%@ include file="logout.jsp"%>
	<%} else {%>
	<%@ include file="login.jsp"%>
	<%}%>
	<a href="#none"><div class="write">
			<h1>글 작성하기</h1>
		</div></a>
	<div class="schedule">
		<iframe src="http://xn--s39aj90b0nb2xw6xh.kr/"></iframe>
	</div>
</div>
