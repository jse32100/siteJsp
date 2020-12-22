<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>


<style>
.b {
        margin-right: 50px;
        margin-left: 50px;
}
</style>

<div class="b">

<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">카테고리</th>
      <th scope="col">작성일</th>
    </tr>
  </thead>
    <c:forEach items="${contact }" var="c" varStatus="no">
  <tbody>
    <tr>
      <th scope="row">${count+no.index+1 } </th>
      <td><a href="contactdetail?num=${c.num }">${c.title }</a></td>
      <td>${c.userid }</td>
      <td>${c.category }</td>
      <td>${c.reg_date }</td>
    </tr>
    
  </tbody>
       </c:forEach>
  
</table>
</div>

<%@ include file="../include/footer.jsp" %>
