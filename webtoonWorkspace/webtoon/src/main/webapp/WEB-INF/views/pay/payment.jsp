<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webtoon/resources/css/payment.css">
    <script defer src="/webtoon/resources/js/payment.js"></script>
    <title>결제페이지</title>
</head>
<body>

    <header>
        <span>결제하기</span>
        <br>
    </header>
    <hr>
    <form action="/webtoon/pay/payment" method="post">
    <div class="coin-info">
    
        <div id="coinInfo">
        ${coin} 코인
        <input type="hidden" id="coin" name="coin" readonly value="${coin}" >
        </div>
    </div>
    <hr>
    <div class="coin-box">
        <span>상품금액</span>
        <span id="coinPrice">${temp}원</span>
    </div>
      <div class="total">
        <span><strong>최종 결제 금액</strong></span>
        <span id="totalPrice"><strong>${temp}원</strong></span>
        <input type="hidden" id="totalprice" name="totalPrice" readonly value="${temp}" >
      </div>
      <br>
      <hr>
      <br>
    <div class="card" style="background-color: #DCE8FF;">
      <img id="card01" src="/webtoon/resources/img/icon/카드.png" alt="카드 아이콘"><span><strong>Moon Pay</strong></span>
      <br><br>
      <input type="radio" name="select"><span>카드 간편결제</span>
      <select name="card">
      	<option value="1">1번 카드</option>
      	<option ></option>
      	<option ></option>
      </select>
      <br><br>
      <div class="card_slide_container">
        <button class="slide-btn" id="slideLeft" onclick="slide('left')">&lt;</button>
        <div class="card_slide">
            <div class="card_list" onclick="selectCard(this)">
                <img class="card_img" src="/webtoon/resources/img/icon/카드7.png" alt="">
            </div>
            <div class="card_list" onclick="selectCard(this)">
                <img class="card_img" src="/webtoon/resources/img/icon/카드8.png" alt="">
            </div>
            <div class="card_list" onclick="selectCard(this)">
                <img class="card_img" src="/webtoon/resources/img/icon/카드6.png" alt="">
            </div>
            <div class="card_list" onclick="selectCard(this)">
                <img class="card_img" src="/webtoon/resources/img/icon/카드6.png" alt="">
            </div>
            <div class="card_list" onclick="selectCard(this)">
                <img class="card_img" src="/webtoon/resources/img/icon/카드7.png" alt="">
            </div>
        </div>
      <button class="slide-btn" id="slideRight" onclick="slide('right')">&gt;</button>
    </div>
    <br>
    <hr>
    <br>
    <button class="pay" type="submit">결제하기</button>
    </form>
</body>
</html>