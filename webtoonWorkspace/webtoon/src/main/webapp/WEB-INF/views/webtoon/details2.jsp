<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>webtoonDetails</title>
    <link rel="stylesheet" href="/webtoon/resources/css/webtoon_details.css">
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
            <button>이전화</button>
            &nbsp;|
            <button>목록</button>
            &nbsp;| 
            <button>다음화</button>
            &nbsp;
        </div>
    </div>
    <main>
        <div id="image-gallery">
            
        </div>
    </main>
</body>
</html>