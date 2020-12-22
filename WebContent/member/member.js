var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/ //전화번호
var nameExp = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]^/ //이름
var emailExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/ //이메일

$(function() {
	$("#check").click(function() {
		
		if($("#userid").val()=="") {
			alert("아이디를 입력해주세요.");
			$("#userid").focus();
			return false;
		}
		
		if($("#pwd").val()=="") {
			alert("비밀번호를 입력해주세요.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd").val().length < 4) {
			alert("비밀번호는 4자리 이상 입력 가능합니다.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd").val() != $("#pwd_check").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return false;
		}
		
		
		if($("#name").val()=="") {
			alert("이름을 넣어주세요.");
			$("#name").focus();
			return false;
		}
		
		if(!$("#name").val().match(nameExp)) {
			alert("이름은 숫자로 시작할 수 없습니다.");
			$("#name").focus();
			return false;
		} 

		
		if($("#email").val()=="") {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		
		if(!$("#email").val().match(emailExp)) {   
			alert("이메일 입력 양식이 아닙니다.");
			$("#email").focus();                         
          return false;         
     	} 
		
		if(!$("#phone").val().match(exp)) {
			alert("전화번호 입력 양식이 아닙니다.");
			$("#phone").focus();
			return false;
		}
		                         

		$("#frm").submit();
		
	});	//fucntion


//아이디 중복확인
$("#IdCheck").click(function() {
	window.open("IdCheck", "", "width=500 height=300")
});

$("#useBtn").click(function(){
	if($("#userid").val()=="") {
		alert("아이디를 입력하세요.");
		$("#userid").focus();
		return false;
	}
	
	if($("#userid").val().length < 4 || ($("#userid").val().length > 12)) {
			alert("아이디는 4~12자 이내로 입력 가능합니다.");
			$("#userid").focus();
			return false;
		}
		
	$.ajax({
		type : "post",
		url : "IdCheck",
		data : {"userid" : $("#userid").val()}, 
		success : function(d) {
			if(d.trim()=="yes") {
				alert("사용 가능한 아이디입니다.");
				$(opener.document).find("#userid").val($("#userid").val());
				self.close();
			} else {
				alert("사용 불가능한 아이디입니다.");
				$("#userid").val("");
			}
		},
		error : function(e) {
			alert("error : " +e);
		}
		
	}); //ajax
}); //function

//닉네임 중복확인
$("#nickcheckBtn").click(function() {
	window.open("nickcheck", "", "width=500 height=300")
});

$("#useBtn2").click(function(){
	if($("#nickname").val()=="") {
		alert("닉네임을 입력하세요.");
		$("#nickname").focus();
		return false;
	}
	
		
	$.ajax({
		type : "post",
		url : "nickcheck",
		data : {"nickname" : $("#nickname").val()}, 
		success : function(d) {
			if(d.trim()=="yes") {
				alert("사용 가능한 닉네임입니다.");
				$(opener.document).find("#nickname").val($("#nickname").val());
				self.close();
			} else {
				alert("사용 불가능한 닉네임입니다.");
				$("#nickname").val("");
			}
		},
		error : function(e) {
			alert("error : " +e);
		}
		
	}); //ajax
}); //function



})//document

var exp = /^[0-9]{3}-[0-9]{4}-[0-9]{4}$/ //전화번호
var nameExp = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]^/ //이름
// 회원 수정
$(function() {
	$("#viewcheck").click(function() {
		if($("#name").val()=="") {
			alert("이름을 넣어주세요.");
			$("#name").focus();
			return false;
		}
		
		if(!$("#name").val().match(nameExp)) {
			alert("이름은 숫자로 시작할 수 없습니다.");
			$("#name").focus();
			return false;
		} 

		
		if($("#pwd").val()=="") {
			alert("비밀번호를 입력해주세요.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd").val().length < 4) {
			alert("비밀번호는 4자리 이상 입력 가능합니다.");
			$("#pwd").focus();
			return false;
		}
		
		if($("#pwd").val() != $("#pwd_check").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd_check").focus();
			return false;
		}
		
		if($("#email").val()=="") {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		if(!$("#phone").val().match(exp)) {
			alert("전화번호 입력 양식이 아닙니다.");
			$("#phone").focus();
			return false;
		}
		$("#form").submit();
	});	//fucntion


//닉네임 중복확인
$("#nickcheckBtn2").click(function() {
	window.open("nickcheck", "", "width=500 height=300")
});

$("#useBtn2").click(function(){
	if($("#nickname").val()=="") {
		alert("닉네임을 입력하세요.");
		$("#nickname").focus();
		return false;
	}
	
	$.ajax({
		type : "post",
		url : "nickcheck",
		data : {"nickname" : $("#nickname").val()}, 
		success : function(d) {
			if(d.trim()=="yes") {
				alert("사용 가능한 닉네임입니다.");
				$(opener.document).find("#nickname").val($("#nickname").val());
				self.close();
			} else {
				alert("사용 불가능한 닉네임입니다.");
				$("#nickname").val("");
			}
		},
		error : function(e) {
			alert("error : " +e);
		}
		
	}); //ajax
}) //function

})


//회원 삭제
function del(userid) {
	if(confirm("정말 삭제할까요?")) {
	$.getJSON("userDelete", {"userid" : userid}, function(data){
		var htmlStr = "";
		$.each(data.jarr, function(key, val){
			htmlStr += "<tr>"
			htmlStr += "<td>"+val.name+"</td>"
			htmlStr += "<td>"+val.userid+"</td>"
			htmlStr += "<td>"+val.nickname+"</td>"
			htmlStr += "<td>"+val.email+"</td>"
			htmlStr += "<td>"+val.phone+"</td>"
			htmlStr += "<td><button type='button' class='btn btn-outline-info btn-circle btn-lg btn-circle ml-2'><i class='fa fa-trash' onclick='del("+val.userid+")'></i></td>"
			htmlStr += "</tr>"

		}); //each
		
		$("table tbody").html(htmlStr);
		$("#countSpan").text(data.countObj.count);

		
	})//function //getJson
	} 
	}
	
