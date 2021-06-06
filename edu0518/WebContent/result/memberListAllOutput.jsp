<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dev.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
	if(!list.isEmpty())
	{
	%>
		<table border = "1">
			<tr><th>ID</th><th>Password</th><th>Name</th></tr>
	<%
	for(int i =0; i<list.size(); i++)
		{
			MemberVO member = list.get(i);
	%>
		<tr><td><%=member.getId() %></td>
		<td><%=member.getPwd() %></td>
		<td><%=member.getName() %></td></tr>
	<%
		}
	}else
	{
		out.print("등록된 회원정보가 없습니다.");
	}
	%>
	</table><br>
	<%@ include file = "home.jsp" %>
</body>
</html>