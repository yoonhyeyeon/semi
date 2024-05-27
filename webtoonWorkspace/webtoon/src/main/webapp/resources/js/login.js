document.getElementById("login-form").addEventListener("submit", function(event){
  event.preventDefault();
  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;
  // 여기에 로그인 처리 로직을 추가하세요.
  console.log("Username: " + username + ", Password: " + password);
});