document.getElementById('search-button').onclick = function() {
    var searchQuery = document.getElementById('search-bar').value;
    if (searchQuery) {
        // 검색 로직 구현
        alert('검색: ' + searchQuery);
    } else {
        alert('검색어를 입력해주세요.');
    }
};





function Chatwrite(refEpisodeNo){
	
	const chatValue = document.querySelector("textarea[name=content]").value;
	document.querySelector("textarea[name=content]").value = "";
	
	$.ajax({
		url : "http://127.0.0.1:8888/webtoon/chat/write",
		type : "post",
		data : {
			"refEpisodeNo" : refEpisodeNo ,
			"content" : chatValue ,
		},
		success : function(x){
			console.log(x);
			ChatLoad(refEpisodeNo);
		},
		fail : function(x){
			console.log(x);
		}, 
	});
}

function ChatLoad(refEpisodeNo){
	
	$.ajax({
		url : "http://127.0.0.1:8888/webtoon/chat/list",
		type : "GET",
		data : {"refEpisodeNo" : refEpisodeNo},
		success : function(data){
			const voList = JSON.parse(data);
			console.log(voList);
			
			let str = "";
			for(let i = 0 ; i < voList.length; i++){
				str += "<div class='comment-container'>";
				str += "<div class='comment'>";
				str += "<strong>"+voList[i].nick+"</strong>"+" | "+"<span>"+voList[i].content+"</span>";
				str += "</div>";
				str += "<span class = 'day'>2024-06-05</span>";
				str += "<button class='good'>"+"👍"+voList[i].hit+"</button>";
				str += "</div>";
				str += "<hr id='webtoon_foot'>" ;
			}
			
			const chatBox = document.querySelector(".chat_box");
			chatBox.innerHTML = str;
		},
		fail : function(error){
			console.log(error);
		},
	});
	
}

const itemBtn = document.querySelector('.itembtn');

itemBtn.addEventListener('click', function() {
    document.querySelector('.clearfix').scrollIntoView({ behavior: "smooth" });
});
