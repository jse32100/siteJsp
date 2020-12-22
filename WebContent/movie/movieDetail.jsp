<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>



<script>
function del(num) {
	if(confirm("게시글을 정말 삭제할까요?")) {
		location.href="delete?num="+num;
		}
	}
	
function cdel(cnum) {
	if(confirm("댓글을 정말 삭제할까요?")) {
		location.href="commentdelete?cnum="+cnum;
		}
	}
</script>
 
<style>
	.button {
      margin: auto;
	   width: 30%;
}

table {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    margin-left : 10px;
    margin-right : 60px;

}
 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}

.navbar{margin-bottom:0;}
section{width:100%; float:left;}
.banner-section{background-image:url("https://static.pexels.com/photos/373912/pexels-photo-373912.jpeg"); background-size:cover; height: 380px; left: 0; position: absolute; top: 0; background-position:0;}
.post-title-block{padding:100px 0;}
.post-title-block h1 {color: #fff; font-size: 85px; font-weight: bold; text-transform: capitalize;}
.post-title-block li{font-size:20px; color: #fff;}
.image-block{float:left; width:100%; margin-bottom:10px;}
.footer-link{float:left; width:100%; background:#222222; text-align:center; padding:30px;}
.footer-link a{color:#A9FD00; font-size:18px; text-transform:uppercase;}
</style>

    
<div class="container">

  <div class="col-lg-9 col-md-9 col-sm-12">
  <h3>${movie.title }</h3>
<p> 작성자 : ${movie.writer }</p>
<p> 작성일 : ${movie.reg_date }</p>

                 <div class="well ">
                    <img src="../upload/${movie.filename }" style="height:auto;">
                </div>
<p class="lead"> ${movie.content }

<br/><br/><br/>
<p> 태그 : ${movie.tag }
<br/><br/><br/>
  <div>
  <input type="button" value="글수정" class="btn btn-primary" onclick="location.href='modify?num=${movie.num }'">
	<input type="button" value="글삭제" class="btn btn-danger" onclick="del('${movie.num }')" >
	<input type="button" value="글목록" class="btn btn-secondary" onclick="location.href='movielist'">
<br/><br/><br/><br/>
</div>
             </div>
             
<br/><br/>
<div align="center">
	<form action="commentInsert" method="post">
	<input type="hidden" name="bnum"  id="bnum" value="${movie.num }">
	<textarea rows="5" cols="50" name="content" id="content"></textarea><br/>
	<button type="submit" class="btn btn-outline-primary"> 댓글쓰기 </button> 
	</form>		
</div>
<br/><br/><br/>
<div id="area"></div>


</div>

<script>
var init = function(){
	$.getJSON("commentList", {"bnum" : $("#bnum").val()}, 
		function(result){
		var htmlStr = "<table>";
		htmlStr += "<tr>";
		htmlStr += "<th>닉네임</th>";
		htmlStr += "<th>내용</th>";
		htmlStr += "<th>작성일</th>";
		htmlStr += "<th>삭제</th>";
		htmlStr += "</tr>";
		$.each(result.jarr, function(key, val) {
			htmlStr += "<tr>";
			htmlStr += "<td>"+val.nickname+"</td>";
			htmlStr += "<td>"+val.content+"</td>";
			htmlStr += "<td>"+val.reg_date+"</td>";
			htmlStr += "<td><a href='javascript:void(0);' onclick='cdel("+val.cnum+")'>삭제</a></td>";
			htmlStr += "</tr>";
		});
		htmlStr += "</table>"
		$("#area").html(htmlStr);
	}
	) //getJSON
}; //init

init();

</script>
             
             
             
             
 <br/><br/><br/><br/><br/><br/><br/><br/>
<%@ include file="../include/footer.jsp" %>
             