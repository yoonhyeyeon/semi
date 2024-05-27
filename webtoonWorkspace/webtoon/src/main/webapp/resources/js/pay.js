document.getElementById('backButton').addEventListener('click', function() {
    window.history.back(); 
  });
  
  document.getElementById('payButton').addEventListener('click', function() {
    const selectedCoin = document.querySelector('input[name="coin"]:checked');
  
    if (selectedCoin) {
        const coinValue = selectedCoin.value;
        const coinPrice = selectedCoin.getAttribute('data-price');

        window.location.href = `payment.html?coin=${coinValue}&price=${coinPrice}`;
    } else {
        alert('충전할 코인을 선택해주세요.');
    }
  });