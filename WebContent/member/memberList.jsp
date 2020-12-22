<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
body{
    margin-top:20px;
}
.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid transparent;
    border-radius: 0;
}
.btn-circle.btn-lg, .btn-group-lg>.btn-circle.btn {
    width: 50px;
    height: 50px;
    padding: 14px 15px;
    font-size: 18px;
    line-height: 23px;
}
.text-muted {
    color: #8898aa!important;
}
[type=button]:not(:disabled), [type=reset]:not(:disabled), [type=submit]:not(:disabled), button:not(:disabled) {
    cursor: pointer;
}
.btn-circle {
    border-radius: 100%;
    width: 40px;
    height: 40px;
    padding: 10px;
}
.user-table tbody tr .category-select {
    max-width: 150px;
    border-radius: 20px;
}
</style>
    
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />

<div class="container">
<div class="row">
    <div class="col-md-12">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title text-uppercase mb-0">User List</h5>
            </div>
            <div class="table-responsive">
                <table class="table no-wrap user-table mb-0">
                  <thead>
                    <tr>
                      <th scope="col" class="border-0 text-uppercase font-medium">Name</th>
                      <th scope="col" class="border-0 text-uppercase font-medium">User ID</th>
                      <th scope="col" class="border-0 text-uppercase font-medium">Nickname</th>
                      <th scope="col" class="border-0 text-uppercase font-medium">Email</th>
                      <th scope="col" class="border-0 text-uppercase font-medium">Phone</th>
                      <th scope="col" class="border-0 text-uppercase font-medium">Delete</th>
                   </tr>
                  </thead>
                  <tbody>
              
                  <c:forEach items="${member }" var="mem">
                  		<tr>
                  		<td>
                          <h5 class="font-medium mb-0"><c:out value="${mem.name }"></c:out></h5>
                      </td>
                      <td>
                      	<span class="text-muted"><c:out value="${mem.userid }"></c:out></span>
                      </td>
                      <td>
                        <%--   <span class="text-muted"><c:out value="${mem.nickname }"></c:out></span> --%>
                      </td>
                      <td>
                          <span class="text-muted"><c:out value="${mem.email }"></c:out></span>
                      </td>
                      <td>
                          <span class="text-muted"><c:out value="${mem.phone }"></c:out></span><br>
                      </td>
                      <td>
                          <span class="text-muted"> <c:if test="${mem.admin==0 }">
                          <button type="button" class="btn btn-outline-info btn-circle btn-lg btn-circle ml-2">
                          <i class="fa fa-trash" onclick="del('${mem.userid}')"></i> </button></c:if></span><br>
                      </td>
                      </tr>
                </c:forEach>
                   
                  </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/>
<%@ include file="../include/footer.jsp" %>
