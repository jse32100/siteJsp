<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script>
function del(userid) {
	if(confirm("정말 탈퇴할까요?")) {
		location.href="revoke?userid="+userid;
	}
}
</script>


<style>
  .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;}

</style>


<div class="container">
  <div class="row">
    <div class="span12">
      <div class="hero-unit center">
          <h1>회원 탈퇴 </h1>
         <small> <font face="Tahoma" color="red">정말로 탈퇴하시겠습니까?</font></small>
          <br /> <br/>
          <p>회원 탈퇴 시 본 사이트가 가지고 있던 개인정보는 모두 파기되며, 탈퇴 후 게시글 삭제를 도와드리기 어렵습니다. </p> 
         	<p> 또한 <b>회원 데이터 복구가 불가능</b>함을 미리 알려드립니다.</p>
          <p><b>정말로 탈퇴하신다면 아래 버튼을 눌러주세요.</b></p>
          <br/><br/>
          <input type="button" class="btn btn-large btn-danger" onclick="del('${member.userid}')" value="회원 탈퇴"><i class="icon-home icon-white"></i> 
        </div>
        <br />

        <br />

    </div>
  </div>
</div>
<br/><br/>
<br/>



<%@ include file="../include/footer.jsp" %>
