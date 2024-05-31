document.addEventListener("DOMContentLoaded", function() {
  const insertBtn = document.querySelector("#insert_btn2");

insertBtn.addEventListener("click", function(event) {
      alert("관리자만 이용 가능합니다.");
  });
});