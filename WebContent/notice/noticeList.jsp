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
</script>

<style>

 button {
       float:right;
}

  .con {
 margin-left: 200px; 
 margin-right: 100px; 
 margin-bottom: auto; 
 margin-top: 40px;
 }
 
 h3{
  margin-bottom: 60px;
  margin-right:30px;
 
 }
</style>

<div class="con">

	<h3 align="center"><strong>공지 게시판<strong></h3>
		

      <c:forEach items="${board }" var="b" varStatus="no">		
<div class="row">
  <div class="span8">
    <div class="row">
      <div class="span8">
        <h4><strong>${count-no.index }. <a href="detail?num=${b.num }"> ${b.title }</a></strong></h4>
      </div>
    </div>
    <div class="row">
      <div class="span2">
        <a href="detail?num=${b.num }" class="thumbnail">
            <img src="../upload/${b.filename }" style="width:300px; height:100px;"> 
        </a>
      </div>
      <div class="span6">      
        <p>
        
        <c:choose>

		<c:when test="${fn:length(b.description) > 19}">
		
		&nbsp &nbsp ${fn:substring(b.description, 0, 17)}...
		
		</c:when>
		
		<c:otherwise>
		
		&nbsp &nbsp ${b.description}
		
		</c:otherwise>
		
		</c:choose>
           
        </p>
        <p><a class="btn" onclick="location.href='detail?num=${b.num }'">Read more</a></p>
        <button type="button" onclick="del('${b.num }')"class="btn btn-outline-danger">삭제</button>
        
      </div>
      
    </div>
    </div>
    </div>
      </c:forEach>

 	<c:if test="${sessionScope.member.admin==1 }">
		<a href="noticeWrite.jsp"> 		
		<button type="button" class="btn btn-info">
		글쓰기
		</button></a> 
		</c:if>
</div>

<br/><br/><br/><br/>
<br/><br/><br/><br/>


<%@ include file="../include/footer.jsp" %>
