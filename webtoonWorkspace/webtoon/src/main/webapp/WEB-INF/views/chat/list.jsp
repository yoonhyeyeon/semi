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

<script type="text/javascript">
	function displaySet(exe, no, refEpisodeNo, content, cmd){
		obj = document.frm;
		obj.no.value = no;
		obj.exe.value = exe;
		obj.refEpisodeNo.value = refEpisodeNo;
		while(content.indexOf("<br>") != -1){
			content = content.replace("<br>","\n");
		}
		obj.content.value = content;
		obj.cmd.value = cmd;
	}
</script>

</head>
<body>
  <div class="back"><a href="/webtoon/details">< 뒤로가기</a></div>
  <br>
  <form action="/webtoon/chat/insert" method="post">
	<div class="clearfix">
		<input type="hidden" name="exe" value="1">
		<c:choose>
			<c:when test="${not empty sessionScope.loginMemberVo}">
			    <textarea name="content" id="commentText" placeholder="댓글을 입력해주세요."></textarea>
	  			<br>
	    		<input type="submit" class="do" value="등록" name="cmd">
			</c:when>
			<c:otherwise>
			    <textarea name="content" id="commentText" placeholder="로그인 시 이용가능 합니다."></textarea>
			    <br>
			    <br>
			</c:otherwise>
		</c:choose>
	</div>
  </form>
<br>
<br>
<hr>
<div class="chat">
  <button class="chat_btn">베스트 댓글</button> | <button class="chat_btn">전체 댓글</button>
</div>
<br>
<div class="main_chat" id="commentSection">
  <br>
  <span class="best">BEST</span>
  <c:forEach items="${voList}" var="vo">
	  <div class="comment-container">
	    <div class="comment">
	        <strong>${vo.nick}</strong> | <c:set value="${content}"></c:set>
	    </div>
	    <span class="day">${vo.enrollDate}</span>
	    <button class="good">👍${hit}</button>
	    <a href="javascript:displaySet(2, '${content}','수정')">수정</a>&nbsp;
	    <a href="javascript:displaySet(3, '${content}', '삭제')">삭제</a>
	  </div>
	  <hr>
  </c:forEach>
</div>
</body>
</html>