<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>웹툰 페이지</title>
    <link rel="stylesheet" href="/webtoon/resources/css/episode.css">
</head>
<body>
    <div id="maind">
        <button id="back"><a href="/webtoon/home"> < &nbsp뒤로가기</a></button>
    </div>
        <br>
        <br>
        <div class="webtoon-container">
            <div class="webtoon-header">
                <img src="/webtoon/resources/img/toon/toon029.jpg" alt="웹툰 이미지" class="webtoon-image">
                <div class="webtoon-info">
                    <h1>화산귀환</h1>
                    <h2><p class="author-genre">작가 : 작가</p></h2>
                    <h2><p class="author-genre">장르: 회귀, 무협/사극,</p></h2>
                    <h4><p>줄거리 : 대 화산파 13대 제자.천하삼대검수 매화검존 청명. 천하를 혼란에 빠뜨린 고금제일마 천마의 목을 치고 십만대산의 정상에서 영면. 백 년의 시간을 뛰어넘어 아이의 몸으로 다시 살아나다. ....뭐? 화산이 망해? 이게   뭔 개소리야!?</p></h4>
                    <h3><p>연령 제한: 15세 이용가</p></h3>
                </div>
                <div class="webtoon-interest">
                    <button>🤍❤️</button>
                </div>
            </div>
        </div>
        <hr>
        <div class="episodes">

            <div class="total">
               <h2>총 6화</h2> 
            </div>
            <hr> <!-- 여기에 구분선 추가 -->
             <c:forEach items="${voList}" var="vo">
	             <a href="/webtoon/details?no=${vo.no}">
	                <div class="episode">
	                    <img src="/webtoon/resources/uploadimg/${vo.profile}" alt="1화 이미지" class="episode-img">
	                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                    <div class="episode-info">
	                        <h2>${vo.no}화. ${vo.title}</h2>
	                        <p>${vo.enrollDate}</p>
	                    </div>
	                </div>
	            </a>
	            <hr> <!-- 여기에 구분선 추가 -->
             </c:forEach>

            <a href="/webtoon/pay/payment2">
                <div class="episode">
                    <img src="/webtoon/resources/img/episode/m01.jpg" alt="1화 이미지" class="episode-img">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="episode-info">
                        <h2>1화. 화산귀환</h2>
                        <p>2024-05-07</p>
                    </div>
                </div>
            </a>

            <hr> <!-- 여기에 구분선 추가 -->
            <a href="/webtoon/webtoon/display">
                <div class="episode">
                    <img src="/webtoon/resources/img/episode/m02.jpg" alt="1화 이미지" class="episode-img">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="episode-info">
                        <h2>2화. 화산귀환</h2>
                        <p>2024-05-13</p>
                    </div>
                </div>
            </a>
            
            <hr> <!-- 여기에 구분선 추가 -->
            <a href="/webtoon/details">
                <div class="episode">
                    <img src="/webtoon/resources/img/episode/m03.jpg" alt="1화 이미지" class="episode-img">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="episode-info">
                        <h2>3화. 화산귀환</h2>
                        <p>2024-05-17</p>
                    </div>
                </div>
            </a>
           
            <hr> <!-- 여기에 구분선 추가 -->
            <a href="/webtoon/details">
                <div class="episode">
                    <img src="/webtoon/resources/img/episode/m04.jpg" alt="1화 이미지" class="episode-img">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="episode-info">
                        <h2>4화. 화산귀환</h2>
                        <p>2024-05-19</p>
                    </div>
                </div>
            </a>
           
            <hr> <!-- 여기에 구분선 추가 -->
            <a href="/webtoon/details">
                <div class="episode">
                    <img src="/webtoon/resources/img/episode/m05.jpg" alt="1화 이미지" class="episode-img">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="episode-info">
                        <h2>5화. 화산귀환</h2>
                        <p>2024-05-25</p>
                    </div>
                </div>
            </a>

            <hr> <!-- 여기에 구분선 추가 -->
            <a href="/webtoon/details">
                <div class="episode">
                    <img src="/webtoon/resources/img/episode/m06.jpg" alt="1화 이미지" class="episode-img">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="episode-info">
                        <h2>6화. 화산귀환</h2>
                        <p>2024-05-31</p>
                    </div>
                </div>
            </a>
            <br><br><br><br><br>
        </div>
</body>
</html>