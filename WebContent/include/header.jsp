<%@page import="com.member.model.MemberDAOImpl"%>
<%@page import="com.member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/portfolio/member/member.js"></script>
<script src="/portfolio/member/home.js"></script>
  
 <script>
function movieClick() {
	alert("스포일러가 함유된 게시판입니다. 입장에 주의해주세요!");
	}
</script> 


<style>
.wrapper{
  float:left;
  width:100%;
  min-height:150px;
}
.navigation{
    float: left;
    width: 100%;
    text-align: center;
}
.navigation ul{
    margin: 0;
    padding: 0;
    float: none;
    width: auto;
    list-style: none;
    display: inline-block;
}
.navigation ul li{
    float: left;
    width: auto;
    margin-right: 60px;
    position: relative;
}
.navigation ul li:last-child{
    margin: 0;
}
.navigation ul li a{
    float: left;
    width: 100%;
    color: #333;
    padding: 16px 0;
    font-size: 16px;
    line-height: normal;
    text-decoration:none;
    box-sizing:border-box;
    text-transform: uppercase;
    font-family: 'Montserrat', sans-serif;      -webkit-transition:color 0.3s ease;
    transition:color 0.3s ease;
}
.navigation .children {
    position: absolute;
    top: 100%;
    z-index: 1000;
    margin: 0;
    padding: 0;
    left: 0;
    min-width: 240px;
    background-color: #fff;
    border: solid 1px #dbdbdb;
    opacity: 0;
    -webkit-transform-origin: 0% 0%;
    transform-origin: 0% 0%;
    -webkit-transition: opacity 0.3s, -webkit-transform 0.3s;
    transition: opacity 0.3s, -webkit-transform 0.3s;
    transition: transform 0.3s, opacity 0.3s;
    transition: transform 0.3s, opacity 0.3s, -webkit-transform 0.3s;
}
.navigation ul li .children  {
    -webkit-transform-style: preserve-3d;
    transform-style: preserve-3d;
    -webkit-transform: rotateX(-75deg);
    transform: rotateX(-75deg);
    visibility: hidden;
}
.navigation ul li:hover > .children  {
    -webkit-transform: rotateX(0deg);
    transform: rotateX(0deg);
    opacity: 1;
    visibility: visible;
}
.navigation ul li .children .children{
	left: 100%;
	top: 0;
}
.navigation ul li.last .children{
	right: 0;
	left: auto;
}
.navigation ul li.last .children .children{
	right: 100%;
	left: auto;
}
.navigation ul li .children li{
	float: left;
	width: 100%;
  margin:0;
}
.navigation ul li .children  a {  
    display: block;
    font-family: "Montserrat", sans-serif;
    text-transform: uppercase;
    font-weight: 700;
    font-size: 11px;
    color: #333;
    text-align: left;
    line-height: 1.5em;
    padding: 16px 30px;
    letter-spacing: normal;
    border-bottom: 1px solid #dbdbdb;
    -webkit-transition: background-color 0.3s ease;
    transition: background-color 0.3s ease;
}
.navigation ul li .children  a:hover{
	color: #fff;
  background-color:goldenrod;
}
.navigation ul li a:hover{
  color:goldenrod;
}

.top-bar {
    background: #555;
    color: #fff;
    font-size: 1.4rem;
    text-align : right;
    padding: 10px 0;
}
.top-bar a.login-btn i, .top-bar a.signup-btn i {
    margin-left: 300px;
}

.top-bar a.login-btn, .top-bar a.signup-btn {
    color: #eee;
    text-transform: uppercase;
    letter-spacing: 0.1em;
    font-size: 1.2rem;
    text-align : right; 

}

.info {

margin-right: 20px;

}

</style>

</head>




<c:set value="${pageContext.request.contextPath }" var="path"/>

 <c:choose>

	<c:when test="${empty sessionScope.member }"> <!-- 세션이 없을 때 -->
	 <div class="top-bar">
	 <div class="login">
	 <a href="${path }/member/login" class="login-btn">
	 <span class="d-none d-md-inline-block">Login</span></a>
	 
	 <a href="${path }/member/register" class="signup-btn">
	 <span class="d-none d-md-inline-block">Join</span></a></div>
    </div>

    </c:when>
    
	 <c:otherwise> <!-- 세션이 있을 때 -->
	 	 <div class="top-bar">
	 	 	<div class="info">
	 	 	${sessionScope.member.nickname }<c:if test="${sessionScope.member.admin==1 }">(관리자)</c:if>님 방문을 환영합니다. <br>
	 	 	 <form action="logout" method="post">	 
	 <a href="${path }/member/logout" class="signup-btn">
	 <span class="d-none d-md-inline-block">Logout</span></a></form>
	 	 	</div>
	 </div>	
 </c:otherwise>
 </c:choose>

<div class="wrapper">
<!--Navigation Start-->
<nav class="navigation">
  <ul>
    <li class="active">
      <a href="${path }/member/home.jsp">Home</a>
    </li>
    <li>
      <a href="${path }/notice/noticelist">Notice</a>
    </li>
    <li>
    
      <a href="${path }/book/booklist">Book</a>
      <ul class="children sub-menu">
        <li>
          <a href="${path }/book/booklist">책 소개</a>
        </li>
        <li>
          <a href="${path }/book/bookreportlist">책 감상</a>
        </li>
        <c:if test="${sessionScope.member.admin==1 }">
         <li>
          <a href="${path }/book/register">책 추가</a>
        </li>
        </c:if>
      </ul>
    </li>
    <li>
      <a href="${path }/movie/movielist" onclick="movieClick()">Movie</a>
      <ul class="children sub-menu">
        <li>
          <a href="${path }/movie/movielist" onclick="movieClick()">영화 감상(스포일러)</a>
        </li>
      </ul>
    </li>
    <c:choose>
    <c:when test="${empty sessionScope.member }">
    
    </c:when>
    <c:otherwise>
    <li>
      <a href="${path }/member/view">My Page</a>
      <ul class="children sub-menu">
        <li>
          <a href="${path }/member/view">회원 정보 수정</a>
        </li>
        <li>
          <a href="${path }/member/contactwrite">문의하기</a>
        </li>
        <li>
          <a href="${path }/member/revoke.jsp">회원 탈퇴</a>
        </li>
        <c:if test="${sessionScope.member.admin==1 }">
        <li>
          <a href="${path }/member/memberList">회원 관리</a>
        </li>
        <li>
          <a href="${path }/member/contactlist">문의 관리</a>
        </li>
        </c:if>
      </ul>
      </li>
      </c:otherwise>
      </c:choose>
</nav>
</div>