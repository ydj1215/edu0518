<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dev.vo.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>삭제 정보 검색</h3>
${error}
<form action = "memberSearch.do" method="post">
Id:<input type="text" name = "id"/>
<input type="hidden" name = "job" value="delete"/>
<input type="submit" value = "Search"/>
</form>

<% 
	MemberVO member = (MemberVO)request.getAttribute("member");
	if(member!=null){ %>
	<h3>검색 정보 결과</h3>
	${member.id } / ${member.pwd } / ${member.name } <br>
	
	<form action = "memberDelete.do" method="post">
	<input type="hidden" name = "id" value="${member.id }"/>
	<input type="submit" value="Delete"/>
	</form>
	
	<%}else{ %>
	${result}
	<%}  %>
</body>
</html>