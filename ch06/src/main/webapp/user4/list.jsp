<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="entity.User4"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	List<User4> users = new ArrayList<>();
	
	try{
		String host = "jdbc:mysql://127.0.0.1:3306/studydb";
		String user = "root";
		String pass = "1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = DriverManager.getConnection(host,user,pass);
		Statement stmt = conn.createStatement();
		
		ResultSet rs =stmt.executeQuery("SELECT * FROM `USER4` ");
		
		while(rs.next()){
			User4 user4 = new User4();
			user4.setUid(rs.getString(1));
			user4.setName(rs.getString(2));
			user4.setGender(rs.getString(3).charAt(0));
			user4.setAge(rs.getInt(4));
			user4.setHp(rs.getString(5));
			user4.setAddr(rs.getString(6));
			users.add(user4);
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
<title>User2 List</title>
</head>
<body>
	<h3>User2 테이블</h3>
	<a href="./register.jsp">등록하기</a>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>성별</td>
			<td>나이</td>
			<th>전화번호</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
		<% for(User4 user : users){ %>
		<tr>
			<th><%= user.getUid() %></th>
			<th><%= user.getName() %></th>
			<th><%= user.getGender() %></th>
			<th><%= user.getAge() %></th>
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