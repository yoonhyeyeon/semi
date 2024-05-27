<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="/webtoon/resources/css/login.css">
   <!-- <script defer src="/webtoon/resources/js/login.js"></script> --> 
</head>
<body>
    <div class="login-container">
      <div id="login-logo">
       <a href="/webtoon/home"><img src="/webtoon/resources/img/logo/loginIcon.png" alt="MOONTOON" id="main-logo"></a> 
      </div>
        <form id="login-form" action="/webtoon/member/login" method="post">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" id="username" name="id" placeholder="아이디 입력" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="pwd" placeholder="비밀번호 입력" required>          
            </div>
            <br>        
            <button type="submit">로그인</button>
            <br><br><br>
        </form>
            <div id="id-pwd">
              <a href="/HTML/find_id.html">아이디 찾기 &nbsp;|</a>
              &nbsp;&nbsp;
              <a href="/HTML/find_pwd.html">비밀번호 찾기</a>
            </div>
        <hr>
        <div class="signup-link">
            아이디가 없으신가요? <a href="/webtoon/member/join">회원가입</a>
        </div>
        <br><br>
        <div id="last-pre">
          <pre>이용약관 | 개인정보 처리 | MOONTOON  </pre> 
      </div>
    </div>
    

</body>
</html>