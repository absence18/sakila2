<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>getBoardOne</h1>
	
	<table border="1">
		
			<tr>
				<th>boardId</th>
				<td>${boardOne.boardId}</td>
			</tr>
			<tr>
				<th>boardTitle</th>
				<td>${boardOne.boardTitle}</td>
			</tr>
			<tr>
				<th>boardContent</th>
				<td>${boardOne.boardContent}</td>
			</tr>
			<tr>
				<th>insertDate</th>
				<td>${boardOne.insertDate}</td>
			</tr>
			<tr>
				<th>username</th>
				<td>${boardOne.username}</td>
			</tr>
		
	</table>

</body>
</html>