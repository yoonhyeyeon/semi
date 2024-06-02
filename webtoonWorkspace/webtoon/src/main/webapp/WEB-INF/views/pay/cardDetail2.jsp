<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="/webtoon/resources/css/cardDetail.css">
</head>
<body>

  <div id="main">
    <h1>등록된 카드 정보</h1><br><br>

      <div id="div-cardChoice">
      은행 : ${sessionScope.payAddVo.bank}
    </div>
      <br>
      <hr><br>
      <div id="div-cardPwd">카드 번호 : ${sessionScope.payAddVo.card_no}</div>
      <hr><br>
      <div id="div-cardPwd">카드 생성일 :  ${sessionScope.payAddVo.enroll_date}</div>
  </div>

</body>
</html>