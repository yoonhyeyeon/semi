<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 프로필 수정</title>
    <link rel="stylesheet" href="/webtoon/resources/css/edit.css">
    <script src="/webtoon/resources/js/join.js"></script>
</head>
<body>
    <div class="container">
        <a href="/webtoon/home" id="img1">
            <img src="/webtoon/resources/img/logo/loginIcon.png" id="moont">
        </a>
        <form id="signup-form" action="/webtoon/admin/edit" method="post">
        	<input type="hidden" name="no" value="${sessionScope.loginAdminVo.no}">
        	
        	<div class="form-group">
            	<label for="name">관리자 아이디: </label>
            	<input type="text" id="nick" name="nick" placeholder="아이디" readonly value="${sessionScope.loginAdminVo.id}" required>
        	</div>
        	
        	<div class="form-group">
            	<label for="name">닉네임: </label>
            	<input type="text" id="nick" name="nick" placeholder="닉네임" readonly value="${sessionScope.loginAdminVo.nick}" required>
        	</div>
        	
        	
            <div class="form-group">
                <label for="password">변경할 비밀번호:</label>
                <input type="password" id="password" name="pwd" placeholder="비밀번호를 입력(숫자,문자,특수문자 포함 8~20자)" required>
            </div>
            
            <div class="form-group">
                <label for="password">변경할 비밀번호 확인:</label>
                <input type="password" id="password" name="pwd2" placeholder="비밀번호를 입력(숫자,문자,특수문자 포함 8~20자)" required>
            </div>
            <button type="submit">수정하기</button>
        </form>
    </div>
    

</body>
</html>