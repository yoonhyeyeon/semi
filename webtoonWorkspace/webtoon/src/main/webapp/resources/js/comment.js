document.addEventListener('DOMContentLoaded', () => {
    const commentText = document.getElementById('commentText');
    const submitComment = document.getElementById('submitComment');
    const commentSection = document.getElementById('commentSection');
  
    // 가정: 사용자가 로그인한 경우, 사용자 닉네임을 가져오는 함수
    function getLoggedInUsername() {
      // 여기서는 임의의 사용자명을 반환하도록 설정합니다.
      return '사용자'; // 실제로는 사용자가 로그인한 상태에서 가져오는 로직을 구현해야 합니다.
    }
  
    submitComment.addEventListener('click', () => {
      const text = commentText.value.trim();
      if (text === "") {
        alert("댓글을 입력해주세요.");
        return;
      }
  
      const commentContainer = document.createElement('div');
      commentContainer.className = 'comment-container';
  
      // 사용자 닉네임 가져오기
      const username = getLoggedInUsername();
  
      // 댓글 작성자 정보 생성
      const commentDiv = document.createElement('div');
      commentDiv.className = 'comment';
      const strong = document.createElement('strong');
      strong.textContent = username; // 사용자 닉네임 적용
      const textNode = document.createTextNode(` | ${text}`);
      commentDiv.appendChild(strong);
      commentDiv.appendChild(textNode);
  
      // 날짜 정보 생성
      const daySpan = document.createElement('span');
      daySpan.className = 'day';
      const now = new Date();
      daySpan.textContent = `${now.getFullYear()}-${String(now.getMonth() + 1).padStart(2, '0')}-${String(now.getDate()).padStart(2, '0')} ${String(now.getHours()).padStart(2, '0')}:${String(now.getMinutes()).padStart(2, '0')}`;
  
      // 좋아요 버튼 생성
      const likeButton = document.createElement('button');
      likeButton.className = 'good';
      likeButton.textContent = '👍';
      likeButton.addEventListener('click', () => {
        const likeCount = parseInt(likeButton.textContent.slice(2) || 0) + 1;
        likeButton.textContent = `👍 ${likeCount}`;
      });
  
      // 댓글 컨테이너에 요소 추가
      commentContainer.appendChild(commentDiv);
      commentContainer.appendChild(daySpan);
      commentContainer.appendChild(likeButton);
  
      // HR 요소 생성
      const hr = document.createElement('hr');
  
      // 댓글 섹션에 새로운 댓글 요소 추가
      commentSection.appendChild(commentContainer);
      commentSection.appendChild(hr);
  
      // 텍스트 입력창 초기화
      commentText.value = "";
    });
  });
  