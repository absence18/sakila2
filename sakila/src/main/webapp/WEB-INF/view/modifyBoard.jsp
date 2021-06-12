<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>modifyBoard</h1>

<form action="${PageContext.request.contextPath}/modifyBoard" method="post">
	<table border="1">
		<tr>
			<th>boardId</th>
			<td><input type=text name = "boardId" value="${boardOne.boardId}" readonly="readonly"></td>
		</tr>
		<tr>
			<th>boardTitle</th>
			<td><input type=text name = "boardTitle"></td>
		</tr>
		<tr>
			<th>boardContent</th>
			<td><textarea name = "boardContent"></textarea></td>
		</tr>
		<tr>
			<th>insertDate</th>
			<td>${boardOne.insertDate}</td>
		</tr>
		<tr>
			<th>username</th>
			<td>${boardOne.username}</td>
		</tr>
		<tr>
			<th>PASSWORD</th>
			<td><input type="password" name = "boardPw"></td>
		</tr>
		
	</table>
	
	<button type="submit">수정</button>
	
</form>

</body>
</html>