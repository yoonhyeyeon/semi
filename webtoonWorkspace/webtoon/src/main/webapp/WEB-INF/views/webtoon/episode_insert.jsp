<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회차 등록</title>
    <link rel="stylesheet" href="/webtoon/resources/css/home_insert.css">
</head>
<body>
    <header>
        <div id="logo">
           <a href="/webtoon/home"><img src="/webtoon/resources/img/logo/moonlogo.png" alt="MoonToon Logo" style="height: 40px;"></a> 
        </div>
  
        <div id="user-controls">

            <a href="/webtoon/admin/mypage"> 
                <img src="/webtoon/resources/img/icon/admin.png" alt="마이페이지" style="height: 20px;">
            </a>
        </div>
    </header>
    <hr class="webtoon-hr">
        <form action="/webtoon/episode/insert" method="post" enctype="multipart/form-data">
        <div class="insert_box">
        	<div>
		        <span>웹툰 번호</span>&nbsp; <input type="number" name="no">
        	</div>
        	<div>
		        <span>웹툰 이름</span>&nbsp; <input type="text" name="webtoonName">
        	</div>
        	<div>
		        <span>작가</span>&nbsp; <input type="text" name="writer">
        	</div>
        	<div>
		        <span>회차 제목</span> <input type="text" name="title">
        	</div>
        	<div>
		        <span>회차 썸네일</span>&nbsp;<input type="file" name="profile">
        	</div>
		    <input class="go" type="submit" value="작성하기">
        </div>
	    </form>
    </div>

</body>
</html>