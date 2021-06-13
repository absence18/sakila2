<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>addBoard</h1>
	
	<form action="${pageContext.request.contextPath}/admin/addBoard" method="post">
		<table border="1">
		
			<tr>
				<td>board_pw</td>
				<td><input type = "text" name = "boardPw"></td>
			</tr>
			<tr>
				<td>board_title</td>
				<td><input type = "text" name = "boardTitle"></td>
			</tr>
			<tr>
				<td>board_content</td>
				<td><input type = "text" name = "boardContent"></td>
			</tr>
			<tr>
				<td>staff_id</td>
				<td><input type = "text" name = "staffId"></td>
			</tr>
		
		</table>
		
		<button type = "submit">board추가</button>
		
	</form>

</body>
</html>