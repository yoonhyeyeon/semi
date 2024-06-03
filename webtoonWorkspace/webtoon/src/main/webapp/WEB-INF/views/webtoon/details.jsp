<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>webtoonDetails</title>
    <link rel="stylesheet" href="/webtoon/resources/css/webtoon_details.css">
    <script defer src="/webtoon/resources/js/webtoon_details.js"></script>
    
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
    
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
        	<button class="itembtn">댓글 목록</button>
        	&nbsp;|
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
            <img src="/webtoon/resources/img/episode/ep001.jpeg" alt="Image 1">
            <img src="/webtoon/resources/img/episode/ep002.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep003.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep004.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep045.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep005.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep006.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep007.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep008.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep009.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep010.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep011.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep012.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep013.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep014.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep015.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep016.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep017.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep018.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep019.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep020.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep021.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep022.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep023.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep024.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep025.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep026.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep027.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep028.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep029.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep030.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep031.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep032.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep033.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep034.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep035.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep036.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep037.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep038.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep039.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep040.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep041.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep042.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep043.jpeg" alt="Image 2">
            <img src="/webtoon/resources/img/episode/ep044.jpeg" alt="Image 2">
        </div>
         <br><br><br>
        <div class="clearfix">
			<c:choose>
				<c:when test="${not empty sessionScope.loginMemberVo}">
				    <textarea name="content" id="commentText" placeholder="댓글을 입력해주세요."></textarea>
		  			<br>
		    		<button class="do" onclick="Chatwrite(${vo.no});">등록</button>
				</c:when>
				<c:otherwise>
				    <textarea name="content" id="commentText" placeholder="로그인 시 이용가능 합니다."></textarea>
				    <br>
				    <br>
				</c:otherwise>
			</c:choose>
       </div>
      <br>
      <br>
      <hr>
      <div class="chat">
        <button class="chat_btn" onclick="ChatLoad(${vo.no});">베스트 댓글</button> | <button class="chat_btn">전체 댓글</button>
      </div>
      <br>
      <div class="main_chat" id="commentSection">
        <br>
        <span class="best">BEST</span>
       		<div class = chat_box>
	 <!--       <div class="comment-container">
	          <div class="comment">
	              <strong>문태웅</strong> | 내가 조장이야
	           </div>
	          <span class="day">2024-05-16 22:07</span>
	          <button class="good">👍</button>
	       	 </div>
	        <hr id="webtoon_foot"> --> 
       	   </div>
      </div>
      <br><br><br>
    </main>
</body>
</html>