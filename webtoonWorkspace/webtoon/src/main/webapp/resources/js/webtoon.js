document.addEventListener("DOMContentLoaded", function() {
    // 웹툰 데이터를 서버로부터 비동기적으로 로드
    fetch('/api/webtoons')
        .then(response => response.json())
        .then(webtoons => {
            const grid = document.querySelector('.webtoon-grid');
            grid.innerHTML = ''; // 기존 내용을 클리어
            webtoons.forEach(webtoon => {
                const card = document.createElement('div');
                card.className = 'webtoon-card';
                card.innerHTML = `
                    <a href="${webtoon.link}">
                        <img src="${webtoon.image}" alt="${webtoon.title}">
                        <div class="webtoon-info">
                            <p class="webtoon-title">${webtoon.title}</p>
                            <p class="webtoon-date">${webtoon.date}</p>
                        </div>
                    </a>
                `;
                grid.appendChild(card); // 새로운 웹툰 카드를 그리드에 추가
            });
        });
});

document.querySelectorAll('.sort-btn').forEach(button => {
    button.addEventListener('click', function() {
        window.location.hash = this.getAttribute('data-sort');
    });
});
