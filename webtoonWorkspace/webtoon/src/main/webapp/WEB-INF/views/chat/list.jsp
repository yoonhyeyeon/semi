<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Comment Page</title>
<link rel="stylesheet" href="/webtoon/resources/css/comment.css">
<script defer src="/JS/comment.js"></script>
</head>
<body>
  <div class="back"><a href="/webtoon/home">< 뒤로가기</a></div>
  <br>
 <c:if test="${sessionScope.loginMemberVo != null}">
	<div class="clearfix">
	    <textarea name="chat_content" id="commentText" placeholder="댓글을 입력해주세요."></textarea>
	    <br>
	    <button class="do" id="submitComment" onclick="writeReply(${vo.no});">등록</button>
	</div>
 </c:if>
 <c:if test="${sessionScope.loginMemberVo == null}">
 	<div class="clearfix">
	    <textarea name="chat_content" id="commentText" placeholder="로그인 후 댓글 작성 가능합니다."></textarea>
	    <br>
	</div>
 </c:if>
<br>
<br>
<hr>
<div class="chat">
  <span id="best">베스트 댓글</span> | <span id="entire">전체 댓글</span>
</div>
<br>
<br>
<div class="main_chat" id="commentSection">
  <br>
  <span class="best">BEST</span>
  <div class="comment-container">
    <div class="comment">
        <strong>문태웅</strong> | 내가 조장이야
    </div>
    <span class="day">2024-05-16 22:07</span>
    <button class="good">👍</button>
</div>
  <hr>
</div>
</body>
</html>