<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
    
   

<style>
.require {
    color: #666;
}
label small {
    color: #999;
    font-weight: normal;
}
</style>
    
    
<div class="container">
	<div class="row">
	
    		  
	    <div class="col-md-8 col-md-offset-2">
	        
    		<h1>Write Book Report Modify</h1>
    		
    		<form action="reportmodify" method="post" enctype="multipart/form-data"  name="reportmodify" id="reportmodify">
    		 <input type="hidden" name="num" value="${book.num }">
    		 <input type="hidden" name="filenames" value="${book.filename }">
    		 
    		    		    		    
    		    <div class="form-group has-error">
    		        <label for="title">Title <span class="require">*</span></label>
    		        <input type="text" class="form-control" value="${book.title }" name="title" id="title">
    		        <span class="help-block">이 칸은 비워놓을 수 없습니다!</span>
    		    </div>
    		    
    		    <div class="form-group">
    		        <label for="writer">Writer</label>
    		        <input type="text" class="form-control" name="writer" value="${book.writer }" readonly="readonly"/>
    		    </div>
    		    
    		    <div class="form-group">
    		        <label for="description">Content</label>
    		        <textarea rows="10" class="form-control" name="content" id="content">${book.content }</textarea>
    		    </div>
    		    
    		    <div class="form-group">
    		        <label for="tag">Tag</label>
    		        <input type="text" class="form-control" value="${book.tag }" name="tag" id="tag">
    		    </div>
    		    
				<div class="form-group">
				  <label for="filename">File Upload</label>
				  <input type="file" name="filename" value="${book.filename }" class="form-control">
					</div>
    		    
    		    <div class="form-group">
    		        <button type="submit" class="btn btn-primary">
    		            Submit
    		        </button>
    		        <button class="btn btn-default">
    		            Cancel
    		        </button>
    		    </div>
		    		</form>    		    
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>
    