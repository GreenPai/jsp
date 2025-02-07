<%@page import="entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<Customer> customers = new ArrayList<>();
	
	try{
		//Context initCtx = new InitialContext();
		//Context ctx = (Context) initCtx.lookup("java:comp/env");
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		
		DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
		
		Connection conn = ds.getConnection();
		
		String sql = "SELECT * FROM `CUSTOMER`";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			Customer customer = new Customer();
			customer.setCustid(rs.getString(1));
			customer.setName(rs.getString(2));
			customer.setHp(rs.getString(3));
			customer.setAddr(rs.getString(4));
			customer.setRdate(rs.getString(5));
			
			customers.add(customer);
		}
		
		rs.close();
		conn.close();
		stmt.close();
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer::list</title>
</head>
<body>
	<h3>고객목록</h3>
	<a href="/ch06/shop">메인이동</a>
	<a href="/ch06/shop/customer/register.jsp">고객등록</a>
	<a href="/ch06/shop/order/list.jsp">주문목록</a>
	
	<table border="1">
		<tr>
			<th>고객아이디</th>
			<th>고객명</th>
			<th>휴대폰</th>
			<th>주소</th>
			<th>가입일</th>
			<th>관리</th>
		</tr>
		<% for(Customer customer : customers){ %>
		<tr>
			<td><%= customer.getCustid() %></td>
			<td><%= customer.getName() %></td>
			<td><%= customer.getHp() %></td>
			<td><%= customer.getAddr() %></td>
			<td><%= customer.getRdate() %></td>
			<td>
				<a href="./modify.jsp?custid=<%=customer.getCustid()%>">수정</a>
				<a href="/ch06/shop/customer/proc/delete.jsp?custId=<%=customer.getCustid()%>">삭제</a>		
			</td>
		</tr>
		<% } %>
	</table>
</body>
</html>