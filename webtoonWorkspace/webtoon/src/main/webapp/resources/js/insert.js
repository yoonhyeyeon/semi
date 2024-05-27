document.addEventListener('DOMContentLoaded', () => {
  const submitButton = document.getElementById('submit_btn');

  submitButton.addEventListener('click', (e) => {
    e.preventDefault();

    const selectTag = document.getElementById('select_content');
    const title = document.getElementById('title_box').value;
    const content = document.getElementById('content_box').value;
    const selectedBoard = selectTag.value;

    const postData = {
      title: title,
      content: content,
    };

    let endpoint;
    if (selectedBoard === 'notice') {
      endpoint = '/api/notice'; // 공지사항 API 엔드포인트
    } else if (selectedBoard === 'freeBoard') {
      endpoint = '/api/freeBoard'; // 자유게시판 API 엔드포인트
    }

    fetch(endpoint, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(postData),
    })
    .then(response => response.json())
    .then(data => {
      if (data.success) {
        alert('글이 성공적으로 등록되었습니다.');
      } else {
        alert('글 등록에 실패했습니다.');
      }
    })
    .catch(error => {
      console.error('Error:', error);
    });
  });
});
