<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webtoon/resources/css/my_page.css">
    <title>MoonToon MyPage</title>
</head>
<body>
    <header>
        <a href="/webtoon/home"><img id="logo" src="/webtoon/resources/img/logo/moonlogo.png" alt="문툰로고"></a>
    </header>
    <hr>
    <div class="user-info">
        <div class="user-image">👤</div>
        <div class="user-details">
            <div>${sessionScope.loginMemberVo.nick}</div>
            <div>${sessionScope.loginMemberVo.vip_no}</div>
            <button onclick="location.href='/webtoon/member/edit'">정보수정</button>
        </div>
    </div>
    <hr>
    <div class="coin-box">
        <span>보유 M코인: ${sessionScope.loginMemberVo.mcoin} <img id="icon02" src="/webtoon/resources/img/icon/동전.png" alt=""></span>
    </div>
    <hr>
    <ul>
        <li><a href="#"><div class="icon"><img src="/webtoon/resources/img/icon/결제내역.png" alt="결제내역 아이콘"></div>결제내역</a></li>
        <hr>
        <li><a href="/webtoon/board/notion/list"><div class="icon"><img src="/webtoon/resources/img/icon/공지사항.png" alt="공지사항 아이콘"></div>공지사항</a></li>
        <hr>
        <li><a href="/HTML/service_center.html"><div class="icon"><img src="/webtoon/resources/img/icon/고객센터.png" alt="고객센터 아이콘"></div>고객센터</a></li>
        <hr>
        <li><a href="#"><div class="icon"><img src="/webtoon/resources/img/icon/쿠폰등록.png" alt="쿠폰등록 아이콘"></div>쿠폰등록</a></li>
        <hr>
        <li><a href="#"><div class="icon"><img src="/webtoon/resources/img/icon/댓글내역.png" alt="댓글내역 아이콘"></div>댓글내역</a></li>
        <hr>
        <li><a href="/webtoon/member/quit"><div class="icon"><img class="icon01" src="/webtoon/resources/img/icon/회원탈퇴.png" alt="회원탈퇴 아이콘"></div>회원탈퇴</a></li>
        <hr>
    </ul>

</body>
</html>