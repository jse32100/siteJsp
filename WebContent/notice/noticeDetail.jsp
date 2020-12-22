<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script>
function del(num) {
	if(confirm("정말 삭제할까요?")) {
		location.href="delete?num="+num;
		}
	}
</script>

<style>
	.button {
      margin: auto;
	   width: 30%;
}

</style>

<form id="frm" action="detail"  method="get">
<input type="hidden" name="num"  id="num" value="${board.num }">
</form>
<div class="container">

  <h1 class="my-4">${board.title }
    <small>${board.reg_date }</small>
  </h1>

  <div class="row">

    <div class="col-md-8">
      <img class="img-fluid" src="../upload/${board.filename }" alt="">
    </div>

    <div class="col-md-4">
      <h3 class="my-3"></h3>
      
        <p>작성자 : ${board.writer }</p>
        <p>태그 : ${board.tag }</p>
      	<br/>
      <h3 class="my-3">공지 내용</h3>
      <p>${board.description }</p>
      
    </div>
    
	
</div>

  </div>
  <!-- /.row -->
  <br/><br/><br/>
    <div class="button">
 	<input type="button" value="글수정" class="btn btn-primary" onclick="location.href='modify?num=${board.num }'">
	<input type="button" value="글삭제" class="btn btn-danger" onclick="del('${board.num }')" >
	<input type="button" value="글목록" class="btn btn-secondary" onclick="location.href='noticelist'">
</div>
<!-- /.container -->
<br/>
<br/>

<%@ include file="../include/footer.jsp" %>
