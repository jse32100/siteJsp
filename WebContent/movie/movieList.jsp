<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<script>
function del(num) {
	if(confirm("정말 삭제할까요?")) {
		location.href="delete?num="+num;
		}
	}
	
function login() {
	alert("로그인이 필요한 서비스입니다.")
	location.href="../member/login"
	}
</script>

<style>
	button {
       float:right;
}
  .con {
 margin-left: 200px; 
 margin-right: 100px; 
 margin-bottom: auto; 
 margin-top: auto;
 }
</style>

<div class="con">
		

      <c:forEach items="${movie }" var="m" varStatus="no">		
<div class="row">
  <div class="span8">
    <div class="row">
      <div class="span8">
        <h4><strong>${count-no.index }.
        
       <c:choose>
      <c:when test="${empty sessionScope.member }">
      <td><a href='javascript:void(0);' onclick="login()"> ${m.title  }</a></td>
      </c:when>
      
      <c:otherwise>
            <td><a href="detail?num=${m.num }"> ${m.title }</a></td>
      </c:otherwise>
      </c:choose>
      </strong>
      </h4>
        
         </div>
    </div>
    <div class="row">
      <div class="span2">
             <c:choose>
      <c:when test="${empty sessionScope.member }">
      <td><a class="thumbnail" href='javascript:void(0);' onclick="login()"> 
      <img src="../upload/${m.filename }" style="width:100px; height:100px;"> 
      </a></td>
      </c:when>
      
      <c:otherwise>
            <a href="detail?num=${m.num }" class="thumbnail">
            <img src="../upload/${m.filename }" style="width:100px; height:100px;"> 
        </a>
      </c:otherwise>
      </c:choose>
      
        
      </div>
            <div class="span6">      
     <c:choose>
		<c:when test="${fn:length(m.content) > 19}">	
		<p> &nbsp &nbsp ${fn:substring(m.content, 0, 17)}...  </p>	
		</c:when>
		
		<c:otherwise>
		<p> &nbsp &nbsp ${m.content }  </p>
		</c:otherwise>
	</c:choose>
		

        
        <c:choose>
      <c:when test="${empty sessionScope.member }">
      <td><a class="btn" href='javascript:void(0);' onclick="login()">Read more</a></td>
      
      </c:when>
      
      <c:otherwise>
       <p><a class="btn" onclick="location.href='detail?num=${m.num }'">Read more</a></p>
      </c:otherwise>
      </c:choose>
        
          <button type="button" onclick="del('${m.num }')"class="btn btn-outline-danger">삭제</button>
        
      </div>
      
    </div>
    </div>
    </div>
      </c:forEach>
      
              <c:choose>
      <c:when test="${empty sessionScope.member }">
     	<a href='javascript:void(0);' onclick="login()"> 		
		<button type="button" class="btn btn-info">
		글쓰기
		</button></a> 
      </c:when>
      
      <c:otherwise>
       <a href="movieWrite.jsp"> 		
		<button type="button" class="btn btn-info">
		글쓰기
		</button></a> 
      </c:otherwise>
      </c:choose>
      
      
</div>

<br/><br/><br/><br/><br/><br/><br/>
<%@ include file="../include/footer.jsp" %>
