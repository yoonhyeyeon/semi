<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/webtoon/resources/css/notion.css">
  <script defer src="/webtoon/resources/js/board.js"></script>
  <title>공지사항</title>
</head>
<body>
  <main>
    <div class="menu">
      <div id="my">
      <c:choose>
      	<c:when test="${not empty sessionScope.loginAdminVo}"> <!-- 관리자가 로그인 했을 때 -->
	        <div>${sessionScope.loginAdminVo.id}</div>
	        <div>${sessionScope.loginAdminVo.nick}</div>
	        <div>${sessionScope.loginAdminVo.no}</div>
	        <button id="insert_btn" onclick="location.href='/webtoon/board/notion/insert'">글쓰기</button>
      	</c:when>
      	<c:when test="${not empty sessionScope.loginMemberVo}"> <!-- 유저가 로그인 했을 떄 -->
      		<div>${sessionScope.loginMemberVo.id}</div>
	        <div>${sessionScope.loginMemberVo.nick}</div>
	        <div>${sessionScope.loginMemberVo.vip_no}</div>
	        <button id="insert_btn2">글쓰기</button>
      	</c:when>
      	<c:otherwise>
      		<div>😊 아이디</div>
	        <div>🙂 닉네임</div>
	        <div>😙 회원 등급</div>
	        <button id="insert_btn2">글쓰기</button>
      	</c:otherwise>
      </c:choose>
      </div>
			<div class="menu_btn">
				<a href="/webtoon/home">👆 웹툰</a>
			</div>
            <div class="menu_btn">
                <a href="/webtoon/myPage">👆 마이페이지</a>
            </div>
			<div class="menu_btn">
				<a href="/webtoon/board/notion/list">👆 공지사항</a>
			</div>
			<div class="menu_btn">
				<a href="/webtoon/board/freeBoard/list">👆 자유게시판</a>
			</div>
            <div class="menu_btn">
				<a href="/webtoon/#">👆 고객센터</a>
			</div>
    </div>
    <div class="list">
      <div id="list_main">공지사항</div>
      <div class="list_detail">
        <div class="list_menu">No</div>
        <div class="list_menu">제목</div>
        <div class="list_menu">작성자</div>
        <div class="list_menu">작성날짜</div>
      </div>
    <div>
      </div class="list">
	      <c:forEach items="${voList}" var="vo">
	        <div class="list_num">
	          <div id="num_side">${vo.no}</div>
	          <div class="num_main"><span class="important">필독</span><a href="/webtoon/board/notion/detail?no=${vo.no}">${vo.title}</a></div>
	          <div class="num_main">${vo.nick}</div>
	          <div id="num_end">${vo.enroll_date}</div>
	        </div>
	      </c:forEach>
        <div class="page_area">
        	<c:if test="${pvo.currentPage > 1}">
          		<a href="/webtoon/board/notion/list?pno=${pvo.currentPage-1}">이전</a>
        	</c:if>
        	<c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="x">
        		<c:if test="${pvo.currentPage == x}">
        			<strong>${x}</strong>
        		</c:if>
        		<c:if test="${pvo.currentPage != x}">
        			<a href="/webtoon/board/notion/list?pno${x}">${x}</a>
        		</c:if>
        	</c:forEach>
        	<c:if test="${pvo.currentPage < pvo.maxPage}">
          		<a href="/webtoon/board/notion/list?pno=${pvo.currentPage+1}">다음</a>
        	</c:if>
        </div>
     </div>
  </main>
</body>
</html>