<%@page import="entity.Order"%>
<%@page import="entity.Product"%>
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

	List<Order> orders = new ArrayList<>();
	
	try{
		//Context initCtx = new InitialContext();
		//Context ctx = (Context) initCtx.lookup("java:comp/env");
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		
		DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
		
		Connection conn = ds.getConnection();
		
		String sql = "SELECT ";
			   sql += "O.ORDERNO, ";
			   sql += "P.PRODNAME, ";
			   sql += "O.ORDERCOUNT,";
			   sql += "P.COMPANY,";
			   sql += "C.`NAME`,";
			   sql += "C.HP,";
			   sql += "O.ORDERDATE ";
			   sql += "FROM `ORDERS` AS O ";
			   sql += "JOIN `PRODUCT` AS P ON O.ORDERPRODUCT = P.prodNo ";
			   sql += "JOIN `CUSTOMER` AS C ON O.ORDERID = C.CUSTID";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			Order order = new Order();
			Product product = new Product();
			Customer customer = new Customer();
			
			order.setOrderNo(rs.getInt(1));
			product.setProdName(rs.getString(2));
			
			order.setOrderCount(rs.getInt(3));
			product.setCompany(rs.getString(4));
			
			customer.setName(rs.getString(5));
			customer.setHp(rs.getString(6));
			
			order.setOrderDate(rs.getString(7));
			
			order.setProduct(product);
			order.setCustomer(customer);
			orders.add(order);
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
<title>product::list</title>
</head>
<body>
	<h3>고객목록</h3>
	<a href="/ch06/shop">메인이동</a>
	<a href="/ch06/shop/product/list.jsp">상품목록</a>
	
	<table border="1">
		<tr>
			<th>주문번호</th>
			<th>주문상품</th>
			<th>주문수량</th>
			<th>제조사</th>
			<th>주문자</th>
			<th>휴대폰</th>
			<th>주문일자</th>
		</tr>
		
		<% for(Order order : orders){ %>
		<tr>
			<td><%= order.getOrderNo()%></td>
			<td><%= order.getProduct().getProdName()%></td>
			<td><%= order.getOrderCount() %></td>
			<td><%= order.getProduct().getCompany() %></td>
			<td><%= order.getCustomer().getName() %></td>
			<td><%= order.getCustomer().getHp() %></td>
			<td><%= order.getOrderDate() %></td>
			
		</tr>
		<% } %>
	</table>
				
</body>
</html>