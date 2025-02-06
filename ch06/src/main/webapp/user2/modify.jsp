<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="entity.User2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");

	//데이터베이스 처리
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "root";
	String pass = "1234";
	User2 user2 = null;
	
	try{
		// 1단계 - JDBC 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection conn = DriverManager.getConnection(host,user,pass);
		String sql = "SELECT * FROM `user2` where `uid`=? ";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, uid);
		
		ResultSet rs = psmt.executeQuery();
		
		if(rs.next()){
			user2 = new User2();
			user2.setUid(rs.getString(1));
			user2.setName(rs.getString(2));
			user2.setBirth(rs.getString(3));
			user2.setAddr(rs.getString(4));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify</title>
</head>
<body>
	<h3>수정하기</h3>
	
	<form action="./proc/modify.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" readonly="readonly" value="<%=user2.getUid()%>"></td>				
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름을 입력해주세요" value="<%=user2.getName()%>" ></td>				
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="date" name="birth" placeholder="생일을 입력해주세요" value="<%=user2.getBirth()%>" ></td>				
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" placeholder="주소를 입력해주세요" value="<%=user2.getAddr()%>" ></td>				
			</tr>
			 <tr>
			 	<td colspan="2" align="right"><input type="submit" value="제출"></td>
			 </tr>
		</table>
	</form>
</body>
</html>