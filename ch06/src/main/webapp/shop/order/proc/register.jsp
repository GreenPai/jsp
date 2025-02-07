<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 데이터 수신
	String orderId = request.getParameter("orderId");
	String orderProduct = request.getParameter("orderProduct");
	String orderCount = request.getParameter("orderCount");

	try{
		Context ctx = (Context) new InitialContext().lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
		Connection conn = ds.getConnection();
		
		String sql = "insert into `orders` set `orderId` = ?, `orderProduct` = ?, `orderCount` = ?, orderDate=NOW() ";
	
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, orderId);
		psmt.setString(2, orderProduct);
		psmt.setString(3, orderCount);
		psmt.executeUpdate();
		
		// 재고수량 수정
		String updateSQL = "update `product` set `stock` = `stock` - ? where `prodNo` = ? " ;
		PreparedStatement psmt2 = conn.prepareStatement(updateSQL);
		psmt2.setString(1, orderCount);	
		psmt2.setString(2, orderProduct);	
		
		psmt2.executeUpdate();
		
		psmt.close();
		conn.close();
		
	}catch(Exception e){
		e.printStackTrace();	
	}
	
	// 목록이동
	response.sendRedirect("/ch06/shop/product/list.jsp");

%>