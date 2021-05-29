<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getCustomerList</title>
</head>
<body>

	<h1>getCustomerList</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>name</th>
				<th>address</th>
				<th>zipCode</th>
				<th>phone</th>
				<th>city</th>
				<th>country</th>
				<th>notes</th>
				<th>SID</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="c" items="${customerList}">
				<tr>
					<td>${c.ID}</td>
					<td>${c.name}</td>
					<td>${c.address}</td>
					<td>${c.zipCode}</td>
					<td>${c.phone}</td>
					<td>${c.city}</td>
					<td>${c.country}</td>
					<td>${c.notes}</td>
					<td>${c.SID}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>