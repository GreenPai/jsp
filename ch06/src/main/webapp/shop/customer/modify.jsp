<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String custid = request.getParameter("custid");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer::modify</title>
</head>
<body>
	<h3>고객수정</h3>
	<a href="/ch06/shop">메인이동</a>
	<a href="/ch06/shop/customer/list.jsp">고객목록</a>
	
	<form action="/ch06/shop/customer/proc/modify.jsp" method="post">
		<table border="1">
			<tr>
				<td>고객아이디</td>
				<td><input type="text" name="custId" readonly="readonly" value="<%= custid %>"> </td>
			</tr>
			<tr>
				<td>고객명</td>
				<td><input type="text" name="name" placeholder="고객명 입력"></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp" placeholder="휴대폰 입력"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" placeholder="주소 입력"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="고객등록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>