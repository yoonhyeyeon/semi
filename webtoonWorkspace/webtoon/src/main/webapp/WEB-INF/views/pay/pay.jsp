<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>캐시충전</title>
    <link rel="stylesheet" href="/webtoon/resources/css/pay.css">
    <script defer src="/webtoon/resources/js/pay.js"></script>
</head>
<body>
    <div class="header">
        <div id="backButton" class="back-button"><a href="/webtoon/mypage">＜ 뒤로가기</a></div>
        <img src="/webtoon/resources/img/icon/동전.png" alt="Coin" class="coin-image">
    </div>
    <div id="section00">캐 시 충 전</div>
      <div id="section01">
          <span>충전 코인</span>
          <span>결제금액</span>
      </div>
    <div class="line"></div>


	<form action="/webtoon/pay" method="post">
    <div class="section popular">
        <div>
            <div class="red-box">인기</div>
            <div class="coin"><input type="radio" name="coin" value="100">100코인</div>
        </div>
        <div class="price">13,700원</div>
    </div>
    <div class="line"></div>

    <div class="section total">
        <div>
            <div class="grey-box">전체</div>
            <div class="coin"><input type="radio" name="coin" value="10">10코인</div>
        </div>
        <div class="price">1,370원</div>
    </div>
    <div class="line"></div>

    <div class="section total">
        <div>
            <div class="coin"><input type="radio" name="coin" value="50">50코인</div>
        </div>
        <div class="price">6,850원</div>
    </div>
    <div class="line"></div>

    <div class="section total">
        <div>
            <div class="coin"><input type="radio" name="coin" value="100">100코인</div>
        </div>
        <div class="price">13,700원</div>
    </div>
    <div class="line"></div>

    <div class="section total">
        <div>
            <div class="coin"><input type="radio" name="coin" value="500">500코인</div>
        </div>
        <div class="price">68,500원</div>
    </div>
    <div class="line"></div>

    <div class="section total">
        <div>
            <div class="coin"><input type="radio" name="coin" value="1000">1000코인</div>
        </div>
        <div class="price">137,000원</div>
    </div>
    <div class="line"></div>
    <button type="submit" class="pay" id="payButton">결제하기</button>
	</form>

</body>
</html>>