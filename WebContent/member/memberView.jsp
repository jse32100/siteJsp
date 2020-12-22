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
body{
    margin-top:20px;
    background:#f8f8f8
}

.col {
    margin-left:20px;
    margin-right:20px;

}

</style>


<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">


<form id="form" action="update"  method="post">
<input type="hidden" name="userid"  id="userid" value="${member.userid }">


<div class="container">
<div class="row flex-lg-nowrap">

  <div class="col">
    <div class="row">
      <div class="col mb-3">
        <div class="card">
          <div class="card-body">
            <div class="e-profile">
              <div class="row">
                <div class="col-12 col-sm-auto mb-3">
                  </div>
                </div>
                <div class="col d-flex flex-column flex-sm-row justify-content-between mb-3">
                  <div class="text-center text-sm-left mb-2 mb-sm-0">
                    <h4 class="pt-sm-2 pb-1 mb-0 text-nowrap"><c:out value="${member.nickname }"></c:out>님의 프로필</h4>
                  </div>
                  <div class="text-center text-sm-right">
                    <span class="badge badge-secondary">
                    
		                <c:choose>
						<c:when test="${member.admin==1 }">
							관리자
						</c:when>
						<c:otherwise>
							일반회원
						</c:otherwise>
						</c:choose>
						
                    </span>
                    <br/>
                  <div class="text-center text-sm-right">  
        <div class="card">
          <div class="card-body">
            <h6 class="card-title font-weight-bold">Support</h6>
            <p class="card-text">문의사항이 있다면 언제든지 연락주세요!</p>
            <button type="button" class="btn btn-primary" onclick="location.href='../member/contactwrite'" >Contact Us</button>
          </div>
        </div>
      </div>
    </div>
                  </div>
                </div>
              </div>
              <ul class="nav nav-tabs">
                <li class="nav-item"><a href="" class="active nav-link">Settings</a></li>
              </ul>
              <div class="tab-content pt-3">
                <div class="tab-pane active">
                    <div class="row">
                      <div class="col">
                        <div class="row">
                          <div class="col">
                            <div class="form-group">
                              <label>User Name</label>
                              <input class="form-control" type="text" name="name" value="${member.name }" readonly="readonly">
                            </div>
                          </div>
                          <div class="col">
                            <div class="form-group">
                              <label>Nickname </label> <a href="javascript:void(0);" id="nickcheckBtn2">중복확인</a>
                              <input class="form-control" type="text" name="nickname" id="nickname" value="${member.nickname }" readonly="readonly">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col">
                            <div class="form-group">
                              <label>Email</label>
                              <input class="form-control" type="text" name="email" id="email" value="${member.email }">
                            </div>
                          </div>
                        </div>
                          <div class="row">
                          <div class="col">
                            <div class="form-group">
                              <label>Phone</label>
                              <input class="form-control" type="text" name="phone" id="phone" value="${member.phone }">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col">
                            <div class="form-group">
                              <label>우편번호 </label> <a href="javascript:void(0);" onclick="openZipSearch()">검색</a>
                              <input class="form-control" type="text" id="zipcode" name="zipcode" value="${member.zipcode }">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col mb-3">
                            <div class="form-group">
                              <label>Address</label>
                              <input class="form-control" type="text" value="${member.address }" id="address" name="address">
                              <input class="form-control" type="text" value="${member.address2 }" id="address2" name="address2">
                              
                            </div>
                          </div>
                        </div>
                          <div class="row">
                      <div class="col-12 col-sm-6 mb-3">
                        <div class="row">
                          <div class="col">
                            <div class="form-group">
                            <label>Change Password</label><br/>
                              <label>Current Password</label>
                              <input class="form-control" type="password" name="pwd" id="pwd" value="${member.pwd }">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col">
                            <div class="form-group">
                              <label>New Password</label>
                              <input class="form-control" type="password" id="pwd" name="pwd" value="${member.pwd }">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col">
                            <div class="form-group">
                              <label>Confirm <span class="d-none d-xl-inline">Password</span></label>
                              <input class="form-control" type="password" id="pwd_check" name="pwd_check" value="${member.pwd }"></div>
                          </div>
                        </div>
                      </div>
                      <div class="col-12 col-sm-5 offset-sm-1 mb-3">
                       
                      </div>
                    </div>
                    <div class="row">
                      <div class="col d-flex justify-content-end">
  						<button type="button" id="viewcheck"> 수정 </button>
                      </div>
                    </div>
                  </form>
                        
                      </div>
                    </div>
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>


  </div>
</div>






<%@ include file="../include/footer.jsp" %>
