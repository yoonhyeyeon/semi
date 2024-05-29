<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/util.jsp" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="/webtoon/resources/css/payment_method_add.css">
  <script defer src="/webtoon/resources/js/payment_method_add.js"></script>
</head>
<body>

  <div id="main">
    
    <form action="/webtoon/pay/add" method="post">
      <div id="div-cardChoice">
      카드 선택 :       
      <input type="text" name="cardNum1" id="cardNum1" maxlength="4"> -
      <input type="text" name="cardNum2" id="cardNum2" maxlength="4"> -
      <input type="text" name="cardNum3" id="cardNum3" maxlength="4"> -
      <input type="password" name="lastNum" id="lastNum" maxlength="4">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <select name="bank" id="bank">
        <option value="문한은행">문한은행</option>
        <option value="문협은행">문협은행</option>
        <option value="문업은행">문업은행</option>
        <option value="문민은행">문민은행</option>
        <option value="문리은행">문리은행</option>
        <option value="문한은행">문한은행</option>
        <option value="문나은행">문나은행</option>
      </select>
    </div>
      <br>
      <hr><br>
      <div id="div-cardPwd">카드 비밀번호 : <input type="password" name="cardPwd" id="cardPwd" maxlength="4"></div>
      <hr>
      <button type="submit" id="cardSmt">등록하기</button>
    </form>
  </div>

</body>
</html>