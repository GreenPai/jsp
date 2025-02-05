<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2.includeTag</title>
	<!--  
		날짜 : 2025/02/05
		이름 : 우상호
		내용 : 4장 JSP 액션태그 실습
	 -->
</head>
<body>
	<h3>1.include 액션태그</h3>
	
	<h4>include 지시자</h4>
	<%@ include file="./inc/_header.jsp" %>
	<%@ include file="./inc/_footer.jsp" %>
	
	<h4>include 메서드</h4>
	<%
		pageContext.include("./inc/_header.jsp");
		pageContext.include("./inc/_footer.jsp");
	
	%>	
	<h4>include 액션태그</h4>
	<jsp:include page="./inc/_header.jsp"></jsp:include>
	<jsp:include page="./inc/_footer.jsp"></jsp:include>
	
</body>
</html>