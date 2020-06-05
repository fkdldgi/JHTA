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
<script type="text/javascript">
	//댓글기능 구현하기 - JSON으로 응답받기
	var xhrList=null;
	function getList(){
		xhrList=new XMLHttpRequest();
		xhrList.onreadystatechange=listOk;
		xhrList.open('get','comments.do?mnum=${vo.mnum}',true);
		xhrList.send();
	}
	function listOk(){
		if(xhrList.readyState==4 && xhrList.status==200){
			delAll();
			var data=xhrList.responseText;
			var json=JSON.parse(data);
			var commList=document.getElementById("commList");
			for(var i=0;i<json.length;i++){
				var num=json[i].num;
				var id=json[i].id;
				var comments=json[i].comments;
				var div=document.createElement("div");
				div.innerHTML="아이디: "+id+"<br>"+
							  "내용: "+comments+"<br>"+
							  "<input type='button' value='삭제' onclick='delComm("+num+")'>";
				div.className="comm";
				commList.appendChild(div);
			}
		}
	}
	var xhrInsert=null;
	function insertComm(){
		var id=document.getElementById("id").value;
		var comments=document.getElementById("comments").value;
		xhrInsert=new XMLHttpRequest();
		xhrInsert.onreadystatechange=insertOk;
		xhrInsert.open('post','insert.do',true);
		xhrInsert.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		xhrInsert.send('mnum=${vo.mnum}&id='+id+'&comments='+comments);
	}
	function insertOk(){
		if(xhrInsert.readyState==4 && xhrInsert.status==200){
			var data=xhrInsert.responseText;
			var json=JSON.parse(data);
			alert(json.chk);
			if(json.chk>0){
				getList();
			}else{
				alert("작성실패!");
			}
		}
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