document.addEventListener("DOMContentLoaded", function() {
  const roles = ["admin", "super_admin", "editor"];
  const role = "${sessionScope.loginAdminVo.role}";
  const insertBtn = document.querySelector("#insert_btn");

  insertBtn.addEventListener("click", function(event) {
    if (!roles.includes(role)) { 
      event.preventDefault();
      alert("관리자만 이용 가능합니다.");
    } else {
      location.href = '/webtoon/board/notion/insert';
    }
  });
});
