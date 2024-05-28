<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>
    <link rel="stylesheet" href="/webtoon/resources/css/join.css">
    <script src="/webtoon/resources/js/join.js?ver=idcheck"></script>
</head>
<body>
    <div class="container">
      <div id="mt-img">
        <a href="/webtoon/home" id="img1">
            <img src="/webtoon/resources/img/logo/loginIcon.png" id="moont">
        </a>
      </div>
        <form id="signup-form" action="/webtoon/member/join" method="post">
            <div class="form-group">
                <label for="text">아이디:</label>
                <div id="button-in-input">
                  <input type="text" id="username" name="id"  placeholder="아이디를 입력 (8~20)" required>
                  <button type="button" id="check-username" onclick="idCheck();">중복확인</button>
                </div>
            </div>
            <div class="form-group">
                <label for="password">비밀번호:</label>
                <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력(숫자,문자,특수문자 포함 8~20자)" required>
            </div>
            <div class="form-group">
              <label for="password2">비밀번호 확인:</label>
              <input type="password" id="pwd2" name="pwd2" placeholder="비밀번호 재입력" required>
          </div>
          <div class="form-group">
            <label for="name">닉네임:</label>
            <input type="text" id="nick" name="nick" placeholder="닉네임 입력" required>
        </div>
        <div class="form-group">
          <label for="text">주소</label>
          <input type="text" id="address"name="address" placeholder="주소 입력" required>
      </div>
      <div class="form-group">
        <label for="phone">전화번호</label>
        <input type="text" id="phone" name="phone" placeholder="010-1111-1111" required onkeyup="formatPhoneNumber()">
    </div>
            <button type="submit">가입하기</button>
        </form>
    </div>
    
    <div id="first">
      <div id="menu">
        <span> MOONTOON (주) |  sponsor: 4주세요 </span>
      </div>
    </div>
    <div id="second">
      <pre>이용약관 개인정보처리방침 책임의 한계와 법적고지 회원정보 고객센터 <br>
        Copyright © MoonToon Corp. All Rights Reserved.</pre>
    </div>

</body>
</html>