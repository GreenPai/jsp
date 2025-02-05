<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 수신
	Cookie[] cookies = request.getCookies();

	String username = null;
	
	for(Cookie cookie : cookies){
		String name = cookie.getName();
		
		if(name.equals("username")){
			username = cookie.getValue();		
		}
		
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>success Login</title>
</head>
<body>
	<h3>로그인 성공</h3>
	<%= username %>님 반갑습니다.<br>
	<a href="../cookie.jsp">처음으로</a>
</body>
</html>