<%@page import="entity.User3"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	List<User3> users = new ArrayList<>();
	
	try{
		String host = "jdbc:mysql://127.0.0.1:3306/studydb";
		String user = "root";
		String pass = "1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = DriverManager.getConnection(host,user,pass);
		Statement stmt = conn.createStatement();
		
		ResultSet rs =stmt.executeQuery("SELECT * FROM `USER3` ");
		
		while(rs.next()){
			User3 user3 = new User3();
			user3.setUid(rs.getString(1));
			user3.setName(rs.getString(2));
			user3.setBirth(rs.getString(3));
			user3.setHp(rs.getString(4));
			user3.setAddr(rs.getString(5));
			users.add(user3);
		}
		
		stmt.close();
		conn.close();
	}catch(Exception e){
		e.printStackTrace();
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User3 List</title>
</head>
<body>
	<h3>User3 테이블</h3>
	<a href="./register.jsp">등록하기</a>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>생일</td>
			<td>전화번호</td>
			<td>주소</td>
			<th>관리</th>
		</tr>
		<% for(User3 user : users){ %>
		<tr>
			<th><%= user.getUid() %></th>
			<th><%= user.getName() %></th>
			<th><%= user.getBirth() %></th>
			<th><%= user.getHp() %></th>
			<th><%= user.getAddr() %></th>
			<th>
				<a href="./modify.jsp?uid=<%= user.getUid() %>">수정</a>			
				<a href="./proc/delete.jsp?uid=<%= user.getUid() %>">삭제</a>			
			</th>
		</tr>
		<%} %>
	</table>
</body>
</html>