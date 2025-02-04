<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String uid = request.getParameter("uid");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	String date = request.getParameter("birth");
	String gender = request.getParameter("gender");
	String addr   = request.getParameter("addr");
	String[] hobbies = request.getParameterValues("hobby");

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<p>내용 출력</p>
	<p>
		아이디: <%= uid %> <br>
		비밀번호: <%= pass %> <br>
		이름: <%= name %> <br>
		생일: <%= date %> <br>
		성별: <%= gender %> <br>
		주소: <%= addr %> <br>
		취미: 
		 
		<% 
			for(String hobby : hobbies){
			out.print(hobby + ", ");
			}
		%><br>
	</p>
	
	
</body>
</html>