<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/webtoon/resources/css/notion_detail.css">
  <title>공지사항 상세보기</title>
</head>
<body>
  <main>
    <div class="menu">
      <div id="my">
        <div>${sessionScope.loginAdminVo.id}</div>
        <div>${sessionScope.loginAdminVo.nick}</div>
        <div>${sessionScope.loginAdminVo.no}</div>
        <button id="insert_btn" onclick="location.href='/webtoon/board/notion/insert'">글쓰기</button>
      </div>
      <div class="menu_btn"><a href="../HTML/webtoon.html">👆 웹툰</a></div>
      <div class="menu_btn"><a href="/webtoon/board/notion/list">👆 공지사항</a></div>
      <div class="menu_btn"><a href="/webtoon/board/freeboard/list">👆 자유게시판</a></div>
    </div>
    <div class="list">
      <div class="list_menu">공지사항 >
        <button id="list_btn"><a href="/webtoon/board/notion/list">목록</a></button>
      </div>
      <div id="title"><strong>${requestScope.vo.title}</strong></div>
      <div class="profile">
        <img id="profile_icon" src="/webtoon/resources/img/profile/베베꼬는.jpeg" alt="프로필아이콘">
        <div id="profile_id">${requestScope.vo.nick}
          <br>
          <div id="date">${requestScope.vo.enroll_date}</div>
        </div>
     </div>
    <div class="content">
      <div id="content_in">${requestScope.vo.content}</div>
    </div>
    <br>
    <c:if test="${requestScope.vo.writer_no == sessionScope.loginAdminVo.no}">
	    <div class="under">
	      <button id="edit_btn" onclick="location.href='edit?no=${vo.no}'">수정</button>
	      <button id="delete_btn" onclick="location.href='delete?no=${vo.no}'">삭제</button>
	    </div>    
    </c:if>
  </main>
</body>
</html>