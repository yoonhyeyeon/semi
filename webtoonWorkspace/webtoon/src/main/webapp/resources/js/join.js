document.addEventListener("DOMContentLoaded", function() {
    const usernameInput = document.getElementById("username");
    const usernameError = document.getElementById("username-error");
    const checkUsernameButton = document.getElementById("check-username");
  
    checkUsernameButton.addEventListener("click", function() {
        const username = usernameInput.value.trim();
        if (username === "") {
            usernameError.textContent = "아이디를 입력하세요.";
            return;
        }
  
        // AJAX 요청을 보내서 서버에서 아이디 중복 여부를 확인하는 코드를 작성합니다.
        // 이 예시에서는 서버에서 응답을 받지 않으므로 단순히 아이디가 입력되었다고 가정합니다.
        usernameError.textContent = "사용 가능한 아이디입니다.";
    });
  });
  function formatPhoneNumber() {
    var input = document.getElementById('phone');
    var inputValue = input.value.replace(/\D/g, ''); // 숫자가 아닌 문자 모두 제거
    
    // 전화번호 최대 길이를 11자로 제한
    if (inputValue.length > 11) {
        inputValue = inputValue.substr(0, 11);
    }
  
    var formattedValue = '';
  
    // 숫자가 10자리 이상일 때 '-' 추가
    if (inputValue.length > 3) {
        formattedValue += inputValue.substr(0, 3) + '-';
        inputValue = inputValue.substr(3);
    }
  
    if (inputValue.length > 4) {
        formattedValue += inputValue.substr(0, 4) + '-';
        inputValue = inputValue.substr(4);
    }
  
    formattedValue += inputValue; // 나머지 문자열 그대로 추가
  
    input.value = formattedValue;
  }