<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Home</h2>
	<a href="${pageContext.request.contextPath}/getBoardList">게시판</a>
	<a href="${pageContext.request.contextPath}/getCustomerList">고객목록</a>
	<a href="${pageContext.request.contextPath}/getInventoryList">재고목록</a>
	<a href="${pageContext.request.contextPath}/getSalesList">매출목록</a>
</body>
</html> 