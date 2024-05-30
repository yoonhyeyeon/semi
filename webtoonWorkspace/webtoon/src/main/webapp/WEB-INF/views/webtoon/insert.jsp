<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>webtoonDetails</title>
    <link rel="stylesheet" href="/webtoon/resources/css/webtoon_details.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script defer src="/webtoon/resources/js/webtoon_details.js"></script>
</head>
<body>
    <header>
        <div id="logo">
           <a href="/webtoon/home"><img src="/webtoon/resources/img/logo/moonlogo.png" alt="MoonToon Logo" style="height: 40px;"></a> 
        </div>
        <div class="search-container">
            <input type="text" id="search-bar" placeholder="검색">
            <button id="search-button">| 🔍</button>
        </div>
        <div id="user-controls">

            <a href="/webtoon/myPage"> 
                <img src="/webtoon/resources/img/icon/mypage.png" alt="마이페이지" style="height: 20px;">
            </a>
        </div>
    </header>
    <hr class="webtoon-hr">
    <div id="webtoon-navigation">
        <div id="webtoon-title"><a href="/webtoon/episode">화산귀환</a> | 1화</div>
        <div id="webtoon-links">
        <form action="/webtoon/webtoon/insert" method="post" enctype="multipart/form-data">
	        <input type="file" name="f" multiple>
	        <input type="submit" value="작성하기">
	    </form>
        </div>
    </div>
    

	
    <main>
    <div id="image-gallery">
        <c:forEach items="${uploadedImages}" var="image">
            <div class="image-item">
                <img src="/webtoon/resources/uploads/${image.changeName}" alt="${image.originName}">
            </div>
        </c:forEach>
    </div>
</main>
</body>
</html>