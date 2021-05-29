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
				<th>staffId</th>
				<th>insertDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${boardList}">
				<tr>
					<td>${c.boardId }</td>
					<td><a href="${pageContext.request.contextPath }/getBoardOne?boardId=${b.boardId}">${c.boardTitle }</a></td>
					<td>${c.staffId }</td>
					<td>${c.insertDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- 검색어 입력창 -->
	<form action="/getBoardList" method="get">
		<label for="searchWord">검색어(제목)</label>
		<input name="searchWord" type="text">
		<button type="submit">검색</button>
	</form>
	
	<!-- 버턴 -->
	<c:if test="${currentPage > 1 }">
	<a href = "${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage-1}">이전</a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
	<a href = "${pageContext.request.contextPath}/getBoardList?currentPage=${currentPage+1}">다음</a>
	</c:if>
</body>
</html>