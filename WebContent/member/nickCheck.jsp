<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style>

body {
            margin-top: 70px;
            margin-left: 30px;
            margin-right: 30px;
        }
        
.btn-label {position: relative;left: -12px;display: inline-block;padding: 6px 12px;background: rgba(0,0,0,0.15);border-radius: 3px 0 0 3px;}
.btn-labeled {padding-top: 0;padding-bottom: 0;}
.btn { margin-bottom:10px; }

.input-group-addon.primary {
    color: rgb(255, 255, 255);
    background-color: rgb(50, 118, 177);
    border-color: rgb(40, 94, 142);
}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/portfolio/member/member.js"></script>

</head>
<body>

<div align="center">
<div class="row form-group">
        <div class="input-group">
            <span class="input-group-addon primary"><span class="glyphicon glyphicon-star"></span></span>
            <input type="text" class="form-control" placeholder="Enter Nickname" id="nickname">
        </div>
        <br/>
	<div class="row">
		<div class="col-md-12">
            <button type="button" id="useBtn2" class="btn btn-labeled btn-success">
                <span class="btn-label"><i class="glyphicon glyphicon-ok"></i></span>Submit</button>
      </div> 
            <br />
	</div>
</div>
</div>

</body>
</html>