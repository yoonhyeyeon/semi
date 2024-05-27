<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="/webtoon/resources/css/edit.css">
    <script src="/webtoon/resources/js/join.js"></script>
</head>
<body>
    <div class="container">
        <a href="/webtoon/home" id="img1">
            <img src="/webtoon/resources/img/logo/loginIcon.png" id="moont">
        </a>
        <form id="signup-form" action="/webtoon/member/edit" method="post">
        	<input type="hidden" name="no" value="${sessionScope.loginMemberVo.no}">
        	<div class="form-group">
            	<label for="name">닉네임:</label>
            	<input type="text" id="nick" name="nick" placeholder="닉네임" readonly value="${sessionScope.loginMemberVo.nick}" required>
        	</div>
            <div class="form-group">
                <label for="password">변경할 비밀번호:</label>
                <input type="password" id="password" name="pwd" placeholder="비밀번호를 입력(숫자,문자,특수문자 포함 8~20자)" required>
            </div>
                        <div class="form-group">
                <label for="password">변경할 비밀번호 확인:</label>
                <input type="password" id="password" name="pwd2" placeholder="비밀번호를 입력(숫자,문자,특수문자 포함 8~20자)" required>
            </div>
        <div class="form-group">
          <label for="text">주소</label>
          <input type="text" id="address"name="address" placeholder="변경할 주소"  value="${sessionScope.loginMemberVo.address}" required>
      </div>
            <button type="submit">수정하기</button>
        </form>
    </div>
    

</body>
</html>