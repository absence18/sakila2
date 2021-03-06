<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>getBoardOne</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		console.log("document ready!");
		$('#addButton').click(function() {
			console.log("btn click!");
			if ($('#username').val().length < 3) {
				alert('username는 3자이상 이어야 합니다');
				$('#username').focus();
			} else if ($('#commentContent').val().length < 5) {
				alert('commentContent는 5자이상 이어야 합니다');
				$('#commentContent').focus();
			} else {
				$('#addCommentForm').submit();
			}

		});
	});
</script>
</head>
<body>
<div class="container">

    <h1>BOARD VIEW</h1>
     <table class="table">
         <tbody>
             <tr>
                <td>board_id :</td>
                <td>${boardMap.boardId}</td>
               </tr>
            <tr>
                   <td>board_title :</td>
                   <td>${boardMap.boardTitle}</td>
            </tr>
            <tr>
                   <td>board_content :</td>
                   <td>${boardMap.boardContent}</td>
            </tr>
            <tr>
                   <td>username :</td>
                   <td>${boardMap.username}</td>
            </tr>
            <tr>
                   <td>insert_date :</td>
                   <td>${boardMap.insertDate}</td>
            </tr>
        </tbody>
    </table>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/modifyBoard?boardId=${boardOne.boardId}">수정</a>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/removeBoard?boardId=${boardOne.boardId}">삭제</a>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/admin/getBoardList">글목록</a>
	<!-- 댓글 목록과 댓글 입력 폼 -->
		<div>
		
			<form id="addCommentForm" action="${pageContext.request.contextPath}/admin/addComment">
			
				<input type="hidden" name="boardId" value="${boardMap.boardId}">
				<table>
				
					<tr>
						<td>username : <input type="text" name="username" id="username"></td>
						<td>commentContent : <textarea name="commentContent" id="commentContent" rows="3" cols="100"></textarea></td>
					</tr>
					
				</table>
				
				<a><input class="btn btn-default" id="addButton" type="button" value="댓글입력"></a>
				
			</form>
			
			<table class="table">
				<c:forEach var="c" items="${commentList}">
					<tr>
						<td>${c.commentContent}</td>
						<td>${c.username}</td>
						<td>${c.insertDate}</td>
						<td><a href="${pageContext.request.contextPath}/admin/deleteCommentByCommentId?commentId=${c.commentId}&boardId=${boardMap.boardId}">
						<button class="btn btn-default" type="button">삭제</button></a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>

	</div>
</body>
</html>