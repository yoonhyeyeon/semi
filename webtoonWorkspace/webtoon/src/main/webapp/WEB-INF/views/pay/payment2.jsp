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
    <form action="/webtoon/pay/payment2" method="post">
    <div class="coin-info">
    
        <div id="coinInfo">
        보유코인 : ${loginMemberVo.mcoin} 
        </div>
    </div>
    <hr>
    <div class="coin-box">
        <span>보유코인</span>
        <span id="coinPrice">${loginMemberVo.mcoin} 코인</span>
    </div>
      <div class="total">
        <span><strong>최종 결제 금액</strong></span>
        <span id="totalPrice"><strong>10코인 </strong></span>
           <input type="hidden" id="coin" name="coin" readonly value="10" >
      </div>
      <br>
      <hr>
      <br>
    <div class="card" style="background-color: #DCE8FF;">
      <img id="card01" src="/webtoon/resources/img/icon/카드.png" alt="카드 아이콘"><span><strong>Moon Pay</strong></span>
      <br><br>
      <br><br>
      <div class="card_slide_container">
    </div>
    <br>
    <hr>
    <br>
    <button class="pay" type="submit">결제하기</button>
    </form>
</body>
</html>