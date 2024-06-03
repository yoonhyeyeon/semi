<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>문의하기 페이지</title>
    <link rel="stylesheet" href="/webtoon/resources/css/qna.css">
</head>
<body>
    <div class="container"> <!-- container 클래스 추가 -->
        <h1>문의하기</h1>
		<form action="/webtoon/customer/inquiry" method="post">
		    <div class="form-group">
		        <label for="title">제목</label>
		        <input type="text" id="title" name="title" required>
		    </div>
		    <div class="form-group">
		        <label for="content">문의 내용</label>
		        <textarea id="content" name="content" required></textarea>
		    </div>
		    <div class="form-group">
		        <label for="author">작성자</label>
		        <input type="text" id="author" name="author" value="${loginMemberVo.nick}" readonly>
		    </div>
		    <button type="submit">문의하기</button>
		</form>
    </div>
		    
</body>
</html>