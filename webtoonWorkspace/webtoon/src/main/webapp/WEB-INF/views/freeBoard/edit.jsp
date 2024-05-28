<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/webtoon/resources/css/board_edit.css">
<script defer src="/webtoon/resources/js/edit.js"></script>
<title>수정하기</title>
</head>
<body>
	<main>
		<div class="menu">
			<div id="my">
				<div>${sessionScope.loginMemberVo.id}</div>
				<div>${sessionScope.loginMemberVo.nick}</div>
				<div>${sessionScope.loginMemberVo.vip_no}</div>
				<button id="insert_btn"
					onclick="location.href='/webtoon/board/freeBoard/insert'">글쓰기</button>
			</div>
			<div class="menu_btn">
				<a href="/webtoon/home">👆 웹툰</a>
			</div>
			<div class="menu_btn">
				<a href="/webtoon/board/notion/list">👆 공지사항</a>
			</div>
			<div class="menu_btn">
				<a href="/webtoon/board/freeBoard/list">👆 자유게시판</a>
			</div>
		</div>
		<div class="list">
			<div id="list_main">수정하기</div>
			<div class="write">
				<div class="select_box">
					<select id="select_content">
						<option value="notice">공지사항</option>
						<option value="freeBoard" selected>자유게시판</option>
					</select>
				</div>
				<form action="/webtoon/board/freeBoard/edit" method="post">
					<input type="hidden" name="no" value="${vo.no}">
					<div id="title_main">
						<span>제목</span><input type="text" id="title_box" name="title" value="${requestScope.vo.title}">
					</div>
					<br>
					<div id="content_main">
						<span>내용</span> <br>
						<textarea id="content_box" name="content">${requestScope.vo.content}</textarea>
					</div>
					<div id="regist">
						<input type="submit" id="submit_btn" value="수정"></input>
					</div>
				</form>
			</div>
		<div>
	</main>
</body>
</html>