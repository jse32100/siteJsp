<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<style>

.container {
margin-bottom: 50px;
}

</style>
    
<form action="login" method="post">

    <div id="login">
        <h3 class="text-center text-white pt-5">Login form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="userid" id="userid" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="pwd" id="pwd" class="form-control">
                            </div>
                            <div class="form-group">
                                <input type="submit" value="로그인" id="loginBtn" class="btn btn-info btn-md">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="register.jsp" class="text-info">Register here</a>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>    
    
    
<script>
$("#loginBtn").click(function() {
	if($("#userid").val()=="") {
		alert("아이디를 입력하세요.")
		$("#userid").focus();
		return false;
		
	}
	if($("#pwd").val()=="") {
		alert("비밀번호를 입력하세요.")
		$("#pwd").focus();
		return false;
}
	$.ajax({
		type : "post",
		url : "login",
		data : {userid:$("#userid").val(), pwd:$("#pwd").val()}, 
		success : function(d) {
			if(d.trim()==-1) {
				alert("회원이 아닙니다.")
			}
			else if(d.trim()==2) {
				alert("비밀번호가 틀립니다.")
			}
			else if(d.trim()==0) {
				alert("일반회원 로그인.")
				$(location).attr("href", "home.jsp");
			}
			else if(d.trim()==1) {
				alert("관리자 로그인.")
				$(location).attr("href", "memberList");
			}
		},
		error : function(e) {
			alert("error : "+e);
		}
	}) //ajax
}) //loginBtn

</script>
    
<%@ include file="../include/footer.jsp" %>
    