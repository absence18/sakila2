<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SalesList</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$('#btn').click(function(){
			console.log('btn click!!')
			$('#SIDForm').submit();			
		});
	});
</script>
</head>
<body>
	<div class="container">
		<h1>getSalesList</h1>

		<!-- 월별 매출 -->
		<table class="table table-striped">
			<thead>
				<tr>
					<th>storeId</th>
					<th>address</th>
					<th>manager</th>
					<th>totalSales</th>
					<th>year</th>
					<th>month</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${getSalesList}">
					<tr>
						<td>${m.storeId}</td>
						<td>${m.address}</td>
						<td>${m.manager}</td>
						<td>${m.totalSales}</td>
						<td>${m.year}</td>
						<td>${m.month}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${currentPage > 1 }">
	<a href = "${pageContext.request.contextPath}/admin/getSalesList?currentPage=${currentPage - 1}&searchWord=${searchWord}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage }">
	<a href = "${pageContext.request.contextPath}/admin/getSalesList?currentPage=${currentPage + 1}&searchWord=${searchWord}">다음</a>
	</c:if>
	
</body>
</html>