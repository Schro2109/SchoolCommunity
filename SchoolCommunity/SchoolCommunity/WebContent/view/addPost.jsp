<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String pType = request.getParameter("pType");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>분경 학생마당</title>
<link rel="stylesheet" href="../intro/style.css">
<script>
function check(){
	if(document.getElementById("title").value==""){
		alert("제목을 입력하세요.");
		document.getElementById("title").focus();
		return false;
	}
	if(document.getElementById("contents").value==""){
		alert("내용을 입력하세요.");
		document.getElementById("contents").focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<div class="container">
		<%@ include file="../intro/header.jsp"%>
		<div class="con">
			<div class="item">
				<form action="addPostCtrl.jsp?pType=<%=pType %>" method="post" onsubmit="return check()">
				<input type="text" id="title" name="title">
				<textarea id="contents" name="contents"></textarea>
				<button type="submit">등록</button>
				</form>
			</div>
		</div>
		<%@include file="../intro/footer.jsp"%>
	</div>
</body>
</html>