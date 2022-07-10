<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("UTF-8");
    String test = request.getParameter("area");
    test = test.replaceAll("\r\n", "<br>");
    out.print(test);
    %>