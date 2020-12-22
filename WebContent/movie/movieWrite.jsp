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
	        
    		<h1>Write Movie Report</h1>
    		
    		<form action="moviewrite" method="post" enctype="multipart/form-data"  name="bookwrite" id="bookreportwrite">
    		    
    		    <div class="form-group has-error">
    		        <label for="title">Title <span class="require">*</span></label>
    		        <input type="text" class="form-control" name="title" id="title">
    		        <span class="help-block">이 칸은 비워놓을 수 없습니다!</span>
    		    </div>
    		    
    		    <div class="form-group">
    		        <label for="writer">Writer</label>
    		        <input type="text" class="form-control" name="writer" value="${member.nickname }" readonly="readonly"/>
    		    </div>
    		    
    		    <div class="form-group">
    		        <label for="cotent">Content</label>
    		        <textarea rows="10" class="form-control" name="content" id="content"></textarea>
    		    </div>
    		    
    		    <div class="form-group">
    		        <label for="tag">Tag</label>
    		        <input type="text" class="form-control" name="tag" id="tag">
    		    </div>
    		    
				<div class="form-group">
				  <label for="filename">File Upload</label>
				  <input type="file" name="filename" class="form-control">
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
    