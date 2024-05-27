document.addEventListener('DOMContentLoaded', function() {
    const params = new URLSearchParams(window.location.search);
    const coin = params.get('coin');
    const price = params.get('price');
  
    if (coin && price) {
        document.getElementById('coinInfo').textContent = `${coin}코인`;
        document.getElementById('coinPrice').textContent = `${Number(price).toLocaleString()}원`;
        document.getElementById('totalPrice').textContent = `${Number(price).toLocaleString()}원`;
    } else {
        alert('잘못된 접근입니다.');
    }
  });
  
  
  document.addEventListener('DOMContentLoaded', () => {
    const cardSlide = document.querySelector('.card_slide');
    const cards = document.querySelectorAll('.card_list');
    let currentCardIndex = 0;
  
    // 처음에 첫 번째 카드만 보이도록 설정
    cards[currentCardIndex].classList.add('active');
  
    window.slide = (direction) => {
      // 현재 카드 숨기기
      cards[currentCardIndex].classList.remove('active');
      if (direction === 'left') {
        currentCardIndex = (currentCardIndex > 0) ? currentCardIndex - 1 : cards.length - 1;
      } else {
        currentCardIndex = (currentCardIndex < cards.length - 1) ? currentCardIndex + 1 : 0;
      }
      // 새로운 카드 보이기
      cards[currentCardIndex].classList.add('active');
    };
  });
  
  function selectCard(element) {
    const selectedCard = document.querySelector('.card_list.selected');
    if (selectedCard) {
      selectedCard.classList.remove('selected');
    }
    element.classList.add('selected');
  }
  