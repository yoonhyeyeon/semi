<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>문의사항 확인</title>
    <link rel="stylesheet" href="/webtoon/resources/css/look.css">
</head>
<body>
    <div class="inquiry-container">
        <h1>문의사항</h1>
        <c:forEach var="inquiry" items="${inquiries}">
            <div class="inquiry">
                <h2>제목: ${inquiry.title}</h2>
                <p><strong>내용:</strong> ${inquiry.content}</p>
                <p><strong>작성자:</strong> ${inquiry.memberNo}</p>
                <p><strong>작성날짜:</strong> ${inquiry.enrollDate}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>