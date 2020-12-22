<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<script>

function openZipSearch() {
	new daum.Postcode({
		oncomplete: function(data) {
			$('[name=zipcode]').val(data.zonecode); // 우편번호 (5자리)
			$('[name=address]').val(data.address);
			$('[name=address2]').val(data.buildingName);
		}
	}).open();
}

</script>


<style>
body {
}
form {
  width: 60%;
  margin: 60px auto;
  background: #f8f1f1;
  padding: 60px 120px 80px 120px;
  text-align: center;
  -webkit-box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
  box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
}
label {
  display: block;
  position: relative;
  margin: 40px 0px;
}
.label-txt {
  position: absolute;
  top: -1.6em;
  padding: 10px;
  font-family: sans-serif;
  font-size: .8em;
  letter-spacing: 1px;
  color: rgb(120,120,120);
  transition: ease .3s;
}
.input {
  width: 100%;
  padding: 10px;
  background: transparent;
  border: none;
  outline: none;
}

.line-box {
  position: relative;
  width: 100%;
  height: 2px;
  background: #BCBCBC;
}

.line {
  position: absolute;
  width: 0%;
  height: 2px;
  top: 0px;
  left: 50%;
  transform: translateX(-50%);
  background: #8BC34A;
  transition: ease .6s;
}

.input:focus + .line-box .line {
  width: 100%;
}

.label-active {
  top: -3em;
}

button {
  display: inline-block;
  padding: 12px 24px;
  background: rgb(220,220,220);
  font-weight: bold;
  color: rgb(120,120,120);
  border: none;
  outline: none;
  border-radius: 3px;
  cursor: pointer;
  transition: ease .3s;
}

button:hover {
  background: #8BC34A;
  color: #ffffff;
}

</style>    
    
    <br/><br/>
        
    <form action="register" method="post" id="frm">

  <label>
  
    <p class="label-txt"> ENTER YOUR USERID <a href="javascript:void(0);" id="IdCheck">중복확인</a></p>
    <input type="text" class="input" id="userid" name="userid" readonly="readonly">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
    <label>
  
    <p class="label-txt">ENTER YOUR PASSWORD</p>
    <input type="password" class="input" id="pwd" name="pwd">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
    <label>
    <p class="label-txt">ENTER YOUR PASSWORD CHECK</p>
    <input type="password" class="input" id="pwd_check" name="pwd_check">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR NAME</p>
    <input type="text" class="input" id="name" name="name">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR NICKNAME <a href="javascript:void(0);" id="nickcheckBtn">중복확인</a></p>
    <input type="text" class="input" id="nickname" name="nickname" readonly="readonly">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR AGE</p>
    <input type="text" class="input" id="age" name="age">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">SELECT YOUR GENDER</p><br>
	  <input type="radio" name="gender" id="gender" value="female"> 여성 &nbsp
	  <input type="radio" name="gender" id="gender" value="male"> 남성 &nbsp
	  <input type="radio" name="gender" id="gender" value="etc"> 그외
  <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR EMAIL</p>
    <input type="text" class="input" id="email" name="email">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR PHONE</p>
    <input type="text" class="input" id="phone" name="phone">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">ENTER YOUR ADDRESS <a href="javascript:void(0);" onclick="openZipSearch()">검색</a></p>
    <input type="text" class="input" id="zipcode" name="zipcode">
    <input type="text" class="input" id="address" name="address">
    <input type="text" class="input" id="address2" name="address2">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">SELECT YOUR Identify</p><br>
	  <input type="radio" name="admin" id="admin" value="0"> 일반회원 &nbsp
	  <input type="radio" name="admin" id="admin" value="1"> 관리자 &nbsp
  <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <br>
  <button type="button" id="check">submit</button>
</form>
    
<%@ include file="../include/footer.jsp" %>