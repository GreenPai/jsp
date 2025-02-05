<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Cookie</title>
</head>
<body>
	<h3>1. 쿠키 실습</h3>
	<%
		String uid = request.getParameter("uid");
		String pass = request.getParameter("pass");
		
		
		// 아이디가 abc, 비밀번호가 1234로 간주
		if("abc".equals(uid) && "1234".equals(pass)){
			
			// 프로젝트 컨텍스트 경로 구하기
			String ctxPath = application.getContextPath();
			
			// 쿠키 생성
			Cookie cookie = new Cookie("username", uid);
			cookie.setMaxAge(60*3); // 3분
			cookie.setPath(ctxPath);
			
			//응답객체로 쿠키 전송
			response.addCookie(cookie);
			
			// 성공페이지 이동
			response.sendRedirect("./successLogin.jsp");
			
		}else{
			response.sendRedirect("./failLogin.jsp");
		}
		
	%>
	<p>
	</p>
	
</body>
</html>