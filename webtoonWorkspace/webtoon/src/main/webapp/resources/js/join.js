
function idCheck(){
  const id = document.querySelector("input[name=id]").value;
  const obj = {
      url : "/webtoon/member/idCheck",
      type : "get",
      data : {"id" : id},
      success : function(x){
          console.log(x);

          if(x === "can"){
              alert("사용 가능한 아이디 입니다.");
          }else{
              alert("중복된 아이디 입니다.");
          }
      },
      error : function(x){console.log("통신 실패");},
  };

  $.ajax(obj);
}

