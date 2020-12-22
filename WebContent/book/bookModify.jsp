<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../include/header.jsp" %>

<style>
.conss {
            margin-left: 150px;
            margin-top: 70px;
            margin-right: 150px;
        }
        
</style>


    		  
<div class="conss">
<legend>BOOK MODIFY</legend>

<form action="modify" method="post" enctype="multipart/form-data"  name="modify" id="modify">
    		  <input type="hidden" name="filenames" value="${book.filename }">
    		  <input type="hidden" name="num" value="${book.num }">
    		  
<div class="form-group">
  <label class="col-md-4 control-label">BOOK TITLE</label>
  <div class="col-md-4">
  <input id="title" name="title" value="${book.title }" placeholder="Enter title" class="form-control input-md" type="text">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">BOOK WRITER</label>  
  <div class="col-md-4">
  <input id="writer" name="writer" value="${book.writer }" placeholder="Enter writer" class="form-control input-md" type="text">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">BOOK Publisher</label>  
  <div class="col-md-4">
  <input id="publisher" name="publisher" value="${book.publisher }" placeholder="Enter publisher" class="form-control input-md" type="text">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">BOOK PRICE</label>  
  <div class="col-md-4">
  <input id="price" name="price" value="${book.price }" placeholder="Enter price" class="form-control input-md" type="text">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">BOOK DESCRIPTION</label>
  <div class="col-md-4">                     
    <textarea class="form-control" id="description" name="description">${book.description }</textarea>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">BOOK CATEGORY</label>
  <div class="col-md-4">
    <select id="category" name="category" class="category">
  <option value="romance">로맨스</option>
  <option value="history">역사</option>
  <option value="sf">SF</option>
  <option value="detective">추리</option>
  <option value="etc">기타</option>
    </select>
  </div>
</div>

			<div class="form-group">
  <label class="col-md-4 control-label">File Upload</label>
  <div class="col-md-4">
  					<input type="file" name="filename" value="${book.filename }" class="form-control">
				</div>
			</div>

  			<div class="col-md-4" align="center">
			<input type="submit" value="등록">
  </div>
  </form>
  
 </div>

 
  <br/> <br/><br/><br/><br/><br/>
   <br/> <br/><br/><br/><br/><br/>
 
 <%@ include file="../include/footer.jsp" %>
 