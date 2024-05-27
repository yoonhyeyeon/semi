<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AdminLogin</title>
    <link rel="stylesheet" href="/webtoon/resources/css/admin.css">
    <script defer src="/webtoon/resources/js/admin.js"></script>
</head>
<body>
    <div class="login-container">
      <div id="login-logo">
       <a href="/webtoon/html/main.html"><img src="/resources/logo/loginIcon.png" alt="ADMINMOONTOON" id="main-logo"></a> 
      </div>
        <form action="/webtoon/admin/login" method="post">
            <div class="form-group">
                <label for="username">관리자 아이디</label>
                <input type="text" id="username" name="username" placeholder="아이디 입력" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" placeholder="비밀번호 입력" required>          
            </div>
            <br>
            <button type="submit">로그인</button>
            <br><br><br>
            
        </form>
        <hr>
        <div class="signup-link">
            관리자가 아니시군요?? <a href="/HTML/login.html">회원 로그인</a>
        </div>
        <br><br>
        <div id="last-pre">
          <pre>이용약관 | 개인정보 처리 | MOONTOON  </pre> 
      </div>
    </div>
    

</body>
</html>