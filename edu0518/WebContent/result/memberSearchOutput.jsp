<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="com.dev.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
		String id = member.getId();
		String pwd = member.getPwd();
		String name = member.getName();
	%>
	<%= id %>/<%= pwd %>/<%= name %>
</body>
</html>