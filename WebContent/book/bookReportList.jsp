<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>


<style>

	button {
       float:right;
}

.b {
        margin-right: 50px;
        margin-left: 50px;
}
</style>

<script>
function login() {
	alert("로그인이 필요한 서비스입니다.")
	location.href="../member/login"
	}
</script>

<div class="b">
		

<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">조회수</th>
      <th scope="col">작성일</th>
    </tr>
  </thead>
  <tbody>
 
    <c:forEach items="${book }" var="b" varStatus="no">
          <tr>
      <th scope="row">${count-no.index } </th>
       <c:choose>
      <c:when test="${empty sessionScope.member }">
      <td><a href='javascript:void(0);' onclick="login()"> ${b.title }</a></td>
      </c:when>
      
      <c:otherwise>
            <td><a href="reportdetail?num=${b.num }">${b.title }</a></td>
      </c:otherwise>
      </c:choose>
      
      <td>${b.writer }</td>
      <td>${b.readcount }</td>
      <td>${b.reg_date }</td>
          </tr>
      
     </c:forEach>
  </tbody>
</table>



              <c:choose>
      <c:when test="${empty sessionScope.member }">
     	<a href='javascript:void(0);' onclick="login()"> 		
		<button type="button" class="btn btn-info">
		글쓰기
		</button></a> 
      </c:when>
      
      <c:otherwise>
<a href="bookReportWrite.jsp"> 		
		<button type="button" class="btn btn-info">
		글쓰기
		</button></a> <br/>
      </c:otherwise>
      </c:choose>

</div>


<br/><br/><br/><br/><br/>
<%@ include file="../include/footer.jsp" %>
