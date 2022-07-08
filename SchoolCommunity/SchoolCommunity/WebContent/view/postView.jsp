<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	int pcode = Integer.parseInt(request.getParameter("pCode"));
	out.print(pcode);
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
				
			</div>
			<%@ include file="../intro/aside.jsp"%>
		</div>
		<%@include file="../intro/footer.jsp"%>
	</div>
</body>
</html>