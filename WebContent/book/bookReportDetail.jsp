<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script>
function del(num) {
	if(confirm("게시글을 정말 삭제할까요?")) {
		location.href="reportdelete?num="+num;
		}
	}
</script>
 
<style>
	.button {
      margin: auto;
	   width: 30%;
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
  <h3>${book.title }</h3>
<p> 작성자 : ${book.writer }</p>
<p> 작성일 : ${book.reg_date }</p>

                 <div class="well ">
                    <img src="../upload/${book.filename }" style="height:auto;">
                </div>
<p class="lead"> ${book.content }

<br/><br/><br/>
<p> 태그 : ${book.tag }
<br/><br/><br/>
  <div>
  <input type="button" value="글수정" class="btn btn-primary" onclick="location.href='reportmodify?num=${book.num }'">
	<input type="button" value="글삭제" class="btn btn-danger" onclick="del('${book.num }')" >
	<input type="button" value="글목록" class="btn btn-secondary" onclick="location.href='bookreportlist'">

</div>
             </div>
             </div>
             
             
             
             
 <br/><br/><br/><br/><br/><br/><br/><br/>
<%@ include file="../include/footer.jsp" %>
             