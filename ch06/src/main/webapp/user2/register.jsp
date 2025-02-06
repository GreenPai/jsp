<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
	<h3>등록하기</h3>
	
	<form action="./proc/register.jsp">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" placeholder="아이디를 입력해주세요"></td>				
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" placeholder="이름을 입력해주세요"></td>				
			</tr>
			<tr>
				<td>생일</td>
				<td><input type="date" name="birth" placeholder="생일을 입력해주세요"></td>				
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" placeholder="주소를 입력해주세요"></td>				
			</tr>
			 <tr>
			 	<td colspan="2" align="right"><input type="submit" value="제출"></td>
			 </tr>
		</table>
	</form>
</body>
</html>