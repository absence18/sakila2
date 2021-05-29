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
				<th>customerId</th>
				<th>name</th>
				<th>email</th>
				<th>storeId</th>
				<th>blackList</th>
				<th>VIP</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="c" items="${customerList}">
				<tr>
					<td>${c.customerId}</td>
					<td>${c.name}</td>
					<td>${c.email}</td>
					<td>${c.storeId}</td>
					<td>${c.blackList}</td>
					<td>${c.VIP}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>