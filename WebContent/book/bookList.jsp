<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../include/header.jsp" %>

<script>
function del(num) {
	if(confirm("정말 삭제할까요?")) {
		location.href="delete?num="+num;
		}
	}
</script>
 
 <form action="booklist" method="post">
				<br/><br/>
 				<h2 align="center"> Book List</h2>
 				<br/><br/> 
<div class="container">
<div class="row">
<c:forEach items="${book }" var="b" varStatus="no">
    <div class="col-md-3">
        <div class="ibox">
            <div class="ibox-content product-box">
                <div class="product-imitation">
                 <img src="../upload/${b.filename }" class="img-responsive" style="width:250px; height:450px;">
                </div>
                <div class="product-desc">
                    <span class="product-price">
                       <a href="#">${b.title }</a> 작가 : ${b.writer }
                    </span>
                    <br/>
                    <span class="product-name">₩${b.price }</span>
                    <small class="text">${b.category }</small>
                                            ${p.description }
               
                    
                    <div class="m-t text-righ">

                        <a href="#" class="btn btn-danger"> Add to cart <i class="fa fa-long-arrow-right"></i> </a>
                        <input type="button" class="btn btn-info" onclick="location.href='detail?num=${b.num }'" value="More Info">
                      
                      <c:if test="${member.admin==1 }">
                       <input type="button" onclick="del('${b.num }')" class="btn btn-dark" value="Delete"> 
                       <i class="fa fa-long-arrow-right"></i></c:if>
                        <br/>
                                                <br/>
                                                <br/>
                        
                    </div>
                </div>
            </div>
            </div>
            </div>
            </c:forEach>
        </div>
    </div>
       </form>
   
       
      
 <%@ include file="../include/footer.jsp" %>
