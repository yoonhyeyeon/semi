<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회차 등록</title>
    <link rel="stylesheet" href="/webtoon/resources/css/home_insert.css">
</head>
<body>
    <header>
        <div id="logo">
           <a href="/webtoon/home"><img src="/webtoon/resources/img/logo/moonlogo.png" alt="MoonToon Logo" style="height: 40px;"></a> 
        </div>
  
        <div id="user-controls">

            <a href="/webtoon/admin/mypage"> 
                <img src="/webtoon/resources/img/icon/admin.png" alt="마이페이지" style="height: 20px;">
            </a>
        </div>
    </header>
    <hr class="webtoon-hr">
    <div id="webtoon-navigation">
        <div id="webtoon-title">
        <form action="/webtoon/episode/insert" method="post" enctype="multipart/form-data">
        <span>웹툰 번호</span>&nbsp; <input type="number" name="no">
        <br>
        <span>웹툰 이름</span>&nbsp; <input type="text" name="webtoonName">
        <br>
        <span>작가</span>&nbsp; <input type="text" name="writer">
        <br>
        <span>회차 제목</span> <input type="text" name="title">
        </div>
        <br>
        <div id="webtoon-links">
	        <span>회차 썸네일</span>&nbsp;<input type="file" name="profile">
	        <input type="submit" value="작성하기">
	    </form>
        </div>
    </div>

</body>
</html>