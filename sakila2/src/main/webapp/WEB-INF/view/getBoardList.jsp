<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoardList</title>
</head>
<body>

	<h1>getBoardList</h1>
	
	<select>
			<option></option>
		<c:forEach var="c" items="${categoryList }">
			<option>${c.name }</option>
		</c:forEach>
	</select>

	<table border="1">
		<thead>
			<tr>
				<th>boardId</th>
				<th>boardTitle</th>
				<th>boardContent</th>
				<th>staffId</th>
				<th>insertDate</th>
				<th>lastUpdate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${boardList}">
				<tr>
					<td>${c.boardId }</td>
					<td>${c.boardTitle }</td>
					<td>${c.boardContent }</td>
					<td>${c.staffId }</td>
					<td>${c.insertDate }</td>
					<td>${c.lastUpdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>