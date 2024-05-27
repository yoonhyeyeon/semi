document.getElementById('search-button').onclick = function() {
    var searchQuery = document.getElementById('search-bar').value;
    if (searchQuery) {
        // 검색 로직 구현
        alert('검색: ' + searchQuery);
    } else {
        alert('검색어를 입력해주세요.');
    }
};
