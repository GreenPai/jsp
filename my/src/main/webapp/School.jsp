<%@page import="sub1.School"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%! 
	School student3 = new School("홍사랑", 3, "양정초등학교");
%>
<html>
<head>
	<meta charset="UTF-8">
	<title>클래스 연습</title>
</head>
<body>



<% 
	School student1 = new School("홍사랑", 3, "양정초등학교");
	School student2 = new School("김시연", 4, "상주초등학교");
	student1.show(out);
	student2.show(out);
%>	

<% student3.show(out); %>
	
</body>
</html>