<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webtoon/resources/css/paymentDetail.css">
    <title>결제내역</title>
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
            <button onclick="location.href='/webtoon/member/edit'">정보수정</button>
        </div>
    </div>
    <hr>
    <ul>
        <li><a href="#"><div class="icon"><img src="/webtoon/resources/img/icon/결제내역.png" alt="결제내역 아이콘"></div>결제내역</a></li>
        <hr>
    </ul>
</body>
</html>