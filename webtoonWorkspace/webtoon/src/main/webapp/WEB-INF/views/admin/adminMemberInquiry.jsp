<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 조회 페이지</title>
    <link rel="stylesheet" href="/webtoon/resources/css/adminMemberInquiry.css">
</head>
<body>
    <div class="container">
        <h1>회원 목록</h1>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>닉네임</th>
                    <th>주소</th>
                    <th>가입 날짜</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="member" items="${members}">
                    <tr>
                        <td>${member.no}</td>
                        <td>${member.nick}</td>
                        <td>${member.address}</td>
                        <td>${member.enroll_date}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>