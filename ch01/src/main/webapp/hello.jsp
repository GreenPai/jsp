<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 
		String hello = "Hello World"; 
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello</title>
	<!-- 
		날짜 : 2025/02/03
		이름 : 우상호
		내용 : JSP 개요와 개발환경 구축 실습
		
		JDK 설치
		 - Oracle JDK 17 다운로드 및 설치
		 
		Eclipse
		 - Eclipse EE버전 다운로드 및 설치
		 
		Tomcat
		 - Java 17 버전과 호환되는 Tomcat 10.1.x 버전 다운로드 및 설치
		 
		Eclipse-Tomcat 설정
		 - Window > preferences > Server > Runtime Environments 에서 Tomcat 경로 추가
	 	 - 하단 Servers 탭에서 add server 클릭 > Apache Tomcat 10.1.x 추가
	 -->
</head>
<body>
	
	<h3><%= hello %></h3>
	<p>
		out.println("Hello JSP!!");
	</p>
	
	<a href="./hello.jsp">hello</a>
	<a href="./welcome.jsp">Welcome</a>
	<a href="./greeting.jsp">Greeting</a>
	
</body>
</html>