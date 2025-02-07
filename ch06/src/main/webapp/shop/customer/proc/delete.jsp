<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터 수신
	String custId = request.getParameter("custId");
	
	// 데이터베이스 처리
	try{
		Context initCtx = new InitialContext();
		Context ctx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) ctx.lookup("jdbc/shop");
		
		Connection conn = ds.getConnection();
		
		String sql = "DELETE FROM `CUSTOMER` WHERE `CUSTID` = ? ";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, custId);
		
		psmt.executeUpdate();
		
		conn.close();
		psmt.close();
		
		response.sendRedirect("../list.jsp");
		
	}catch(Exception e){
		e.printStackTrace();
	}
	

%>