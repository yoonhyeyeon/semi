        // 전화번호 입력 필드에 자동으로 형식을 지정해주는 함수
        function formatPhoneNumber() {
            var input = document.getElementById('phone');
            var inputValue = input.value;
  
            // 숫자만 남기고 나머지는 모두 제거
            var formattedValue = inputValue.replace(/\D/g, '');
  
            // 전화번호 형식에 맞게 변환 (010-xxxx-xxxx)
            if (formattedValue.length >= 10) {
                var formattedPhoneNumber = formattedValue.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
            } else {
                var formattedPhoneNumber = formattedValue;
            }
  
            // 변환된 전화번호를 입력 필드에 설정
            input.value = formattedPhoneNumber;
  
            // 13자 이상의 문자열을 입력할 수 없도록 함
            if (input.value.length > 13) {
                input.value = input.value.slice(0, 13);
            }
        }