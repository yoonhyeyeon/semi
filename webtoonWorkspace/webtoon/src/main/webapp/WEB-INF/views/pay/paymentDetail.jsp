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
        </div>
    </div>
    <hr>
    <ul>
        <li><div class="icon"><img src="/webtoon/resources/img/icon/결제내역.png" alt="결제내역 아이콘"></div>결제내역</li>
        <hr>
    </ul>
        <li>회원번호 : ${sessionScope.loginMemberVo.no}</li>
        <hr>
        <c:forEach items="${payVoList}" var="vo">
        	결제가격 : ${vo.pay} 
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	결제일시 : ${vo.enroll_date}
        	<hr>
        </c:forEach>
        총결제 금액 : ${loginMemberVo.pay_total}원
</body>
</html>