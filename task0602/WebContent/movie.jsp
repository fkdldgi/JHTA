<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.comm{width:400px;height:100px;border:1px solid #aaa;margin-bottom:5px;}
</style>
<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	//댓글기능 구현하기 - JSON으로 응답받기
	function getList(){
		$.ajax({
			url:"comments.do",
			data:{"mnum":"${vo.mnum}"},
			dataType:"json",
			success:function(data){
				delAll();
				for(let i=0; i<data.length; i++){
					var num=data[i].num;
					var id=data[i].id;
					var comments=data[i].comments;
					var div=$("<div></div>").appendTo("#commList");
					div.append("아이디: "+id+"<br>"+
							  "내용: "+comments+"<br>"+
							  "<input type='button' value='삭제' onclick='delComm("+num+")'>");
					div.prop("class","comm");
				}			
			}
		});		
	}
	
	function insertComm(){
		$.ajax({
			url:"insert.do",
			data:{"mnum":"${vo.mnum}","id":$("#id").val(),"comments":$("#comments").val()},
			dataType:"json",
			success:function(data){
				if(data.chk>0){
					getList();
				}else{
					alert("작성실패!");
				}
			}
		});
	}
	var delComm=function(num){
		$.ajax({
			url:"delete.do",
			data:{"num": num },
			success:function(data){
				if($(data).find("code").text()=="success"){
					getList();
				}else{
					alert("작성실패!");
				}
			}
		});
	}
	//전체 자식노드삭제
	function delAll(){
		var commList=document.getElementById("commList");
		//방법1(쌤 풀이)
		var childs=commList.childNodes; //전체 자식노드(모든댓글) 얻어오기
		var len=childs.length;
		for(var i=len-1; i>=0; i--){
			var comments=childs.item(i);
			commList.removeChild(comments);
		}
		//방법2
		/* while(div.hasChildNodes()){
			div.removeChild(div.firstChild);
		} */
	}
	
</script>
</head>
<body onload="getList()"> <!-- body가 호출 될 때 실행되게 하거나 위의 script문을 아래로 내려도됨 -->
<h1>영화 상세페이지</h1>
<div>
	<h1>${vo.title }</h1>
	<p>
		내용 : ${vo.content }<br>
		감독 : ${vo.director }
	</p>
</div>
<div> <!-- 댓글이 보여질 div -->
	<div id="commList"></div>
	<div>
		아이디<br>
		<input type="text" id="id"><br>
		댓글<br>
		 <textarea rows="3" cols="30" id="comments"></textarea><br>
		<input type="button" value="등록" onclick="insertComm()">
		<!-- ajax로 댓글등록하고 성공/실패메시지 alert로 보이기 -->
	</div>
</div>
</body>
</html>