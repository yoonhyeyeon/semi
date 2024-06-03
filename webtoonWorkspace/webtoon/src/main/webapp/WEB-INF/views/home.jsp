
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MoonToon</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
    <link rel="stylesheet" href="/webtoon/resources/css/main.css">
    <script defer src="/webtoon/resources/js/main.js"></script>
</head>
<body>
    <header>
        <div id="logo">
          <a onclick="location.href='/webtoon/webtoon'"><img src="/webtoon/resources/img/logo/moontoon.png" alt="MoonToon Logo" style="height: 40px;"></a>  
        </div>
        
        
<c:choose>
    <c:when test="${not empty sessionScope.loginAdminVo}">
        <!-- 관리자 로그인 시 보여줄 내용 -->
        <div id="admin-controls">
            관리자: ${sessionScope.loginAdminVo.nick} <br>
            <a onclick="location.href='/webtoon/admin/logout'">로그아웃</a>&nbsp;
            <a href="/webtoon/admin/mypage">
                <img src="/webtoon/resources/img/icon/mypagelast.png" alt="마이페이지" style="height: 20px;">
            </a>
        </div>
    </c:when>
    <c:when test="${not empty sessionScope.loginMemberVo}">
        <!-- 일반 회원 로그인 시 보여줄 내용 -->
        <div id="user-controls">
            닉네임 : ${sessionScope.loginMemberVo.nick} <br>
            <a onclick="location.href='/webtoon/member/logout'">로그아웃</a>&nbsp;
            <a href="/webtoon/myPage">
                <img src="/webtoon/resources/img/icon/mypagelast.png" alt="마이페이지" style="height: 20px;">
            </a>
        </div>
    </c:when>
    <c:otherwise>
        <!-- 아무도 로그인하지 않은 경우 보여줄 내용 -->
        <div id="user-controls">
            <a href="/webtoon/admin/login">
                <img src="/webtoon/resources/img/icon/admin.png" alt="로그인" style="height: 20px;">
            </a>
            <a href="/webtoon/member/login">
                <img src="/webtoon/resources/img/icon/고객센터.png" alt="로그인" style="height: 20px;">
            </a>
        </div>
    </c:otherwise>
</c:choose>
        

        
        
    </header>
    <hr class="webtoon-hr">
    <div class="promotion">
        <div class="slider-container">
            <button class="slide-btn left-btn">&#10094;</button>
            <div class="slider">
                <!-- 이 부분에 더 많은 이미지를 추가할 수 있습니다. -->
                <img src="/webtoon/resources/img/toon/toon001.jpg" alt="웹툰 이미지 1">
                <img src="/webtoon/resources/img/toon/toon029.jpg" alt="웹툰 이미지 2">
                <img src="/webtoon/resources/img/toon/toon003.jpg" alt="웹툰 이미지 3">
                <img src="/webtoon/resources/img/toon/toon016.jpg" alt="웹툰 이미지 4">
                <img src="/webtoon/resources/img/toon/toon005.jpg" alt="웹툰 이미지 5">
                <img src="/webtoon/resources/img/toon/toon006.jpg" alt="웹툰 이미지 6">
                <!-- 추가 이미지 -->
                <img src="/webtoon/resources/img/toon/toon007.jpg" alt="웹툰 이미지 7">
                <img src="/webtoon/resources/img/toon/toon008.jpg" alt="웹툰 이미지 8">
                <img src="/webtoon/resources/img/toon/toon032.webp" alt="웹툰 이미지 9">
                <img src="/webtoon/resources/img/toon/toon011.jpg" alt="웹툰 이미지 9">
                <img src="/webtoon/resources/img/toon/toon012.jpg" alt="웹툰 이미지 9">
                <img src="/webtoon/resources/img/toon/toon013.jpg" alt="웹툰 이미지 9">
                <img src="/webtoon/resources/img/toon/toon014.jpg" alt="웹툰 이미지 9">
                <img src="/webtoon/resources/img/toon/toon030.jpg" alt="웹툰 이미지 9">
            </div>
            <button class="slide-btn right-btn">&#10095;</button>
        </div>
    </div>


 <div class="content">
        <div class="webtoon-days">
            <div class="webtoon-day" id="monday">
                <h3>월</h3>
                <div class="webtoon-grid">
						<c:forEach items="${voList}" var="vo">
						    <c:if test="${vo.day == 1}">
						        <div class="webtoon-item">
						            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
						        </div>
						    </c:if>
						</c:forEach>
                    <div class="webtoon-item">
                       <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon001.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon002.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon003.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon004.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon005.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon030.jpg" alt="웹툰 이미지"></a>
                    </div>

                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
            <div class="webtoon-day" id="tuesday">
                <h3>화</h3>
                <div class="webtoon-grid">
					<c:forEach items="${voList}" var="vo">
					    <c:if test="${vo.day == 2}">
					        <div class="webtoon-item">
					            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
					        </div>
					    </c:if>
					</c:forEach>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon029.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon006.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon007.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon008.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon009.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
            <div class="webtoon-day" id="wednesday">
                <h3>수</h3>
                <div class="webtoon-grid">
					<c:forEach items="${voList}" var="vo">
					    <c:if test="${vo.day == 3}">
					        <div class="webtoon-item">
					            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
					        </div>
					    </c:if>
					</c:forEach>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon031.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon010.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon011.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon012.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon038.jpg" alt="웹툰 이미지"></a>
                    </div>
                    
                    
                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
            <div class="webtoon-day" id="thursday">
                <h3>목</h3>
                <div class="webtoon-grid">
					<c:forEach items="${voList}" var="vo">
					    <c:if test="${vo.day == 4}">
					        <div class="webtoon-item">
					            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
					        </div>
					    </c:if>
					</c:forEach>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon013.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon014.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon015.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon016.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon032.webp" alt="웹툰 이미지"></a>
                    </div>
                    

                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
            <div class="webtoon-day" id="friday">
                <h3>금</h3>
                <div class="webtoon-grid">
					<c:forEach items="${voList}" var="vo">
					    <c:if test="${vo.day == 5}">
					        <div class="webtoon-item">
					            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
					        </div>
					    </c:if>
					</c:forEach>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon017.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon018.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon019.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon020.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon037.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
            <div class="webtoon-day" id="saturday">
                <h3>토</h3>
                <div class="webtoon-grid">
					<c:forEach items="${voList}" var="vo">
					    <c:if test="${vo.day == 6}">
					        <div class="webtoon-item">
					            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
					        </div>
					    </c:if>
					</c:forEach>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon021.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon022.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon023.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon024.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon035.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon036.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
            <div class="webtoon-day" id="sunday">
                <h3>일</h3>
                <div class="webtoon-grid">
					<c:forEach items="${voList}" var="vo">
					    <c:if test="${vo.day == 7}">
					        <div class="webtoon-item">
					            <a href="/webtoon/episode?no=${vo.no}"><img src="/webtoon/resources/uploadimg/${vo.profile}" alt="웹툰 이미지"></a>
					        </div>
					    </c:if>
					</c:forEach>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon025.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon026.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon027.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon028.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon033.jpg" alt="웹툰 이미지"></a>
                    </div>
                    <div class="webtoon-item">
                        <a href="/webtoon/episode"><img src="/webtoon/resources/img/toon/toon034.jpg" alt="웹툰 이미지"></a>
                    </div>

                    <!-- 추가 웹툰 아이템들 -->
                </div>
            </div>
      
        </div>
        <div class="side-bar">
            <input type="text" placeholder="검색">
            <div>광고</div>
        </div>
    </div>
</body>
</html>