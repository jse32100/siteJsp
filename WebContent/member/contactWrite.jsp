<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
.jumbotron {
background: #358CCE;
color: #FFF;
border-radius: 0px;
}
.jumbotron-sm { padding-top: 24px;
padding-bottom: 24px; }

.jumbotron small {
color: #FFF;
}

.h1 small {
font-size: 24px;
}
</style>


<div class="container">
    <div class="row">
    <div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                    	문의하기 <small> 자유롭게 문의해주세요! </small></h1>
            </div>
        </div>
    </div>
</div>
        <div class="col-md-12">
            <div class="well well-sm">
                <form action="contactwrite" method="post">
                <input type="hidden" name="phone" value="${member.phone }">
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                      
                        <label for="title">
                                	제목 </label>
                            <input type="text" class="form-control" id="title" name="title"  placeholder="Enter title"/>
                        </div>
                        	 <label for="name">
                                Name</label>
                            <input type="text" class="form-control" value="${member.name }" id="name" name="name" placeholder="Enter name" required="required" />
                         <label for="userid">
                                ID </label>
                            <input type="text" class="form-control" value="${member.userid }" id="userid" name="userid" readonly="readonly" />
                        </div>         
                        </div>
                        
                          
                        <div class="form-group">
                            <label for="email">
                                Email Address</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" value="${member.email }" name="email" id="email" placeholder="Enter email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="category">
                                Subject</label>
                            <select id="category" name="category" class="form-control" required="required">
                                <option value="na" selected="">Choose One:</option>
                                <option value="service">홈페이지 서비스</option>
                                <option value="delivery">배송 문제</option>
                                <option value="etc">그 외</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Message</label>
                            <textarea name="message" id="message" class="form-control" rows="9" cols="40" required="required"
                                placeholder="Message"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
            </form>
                </div>
            </div>
        </div>
<%@ include file="../include/footer.jsp" %>
