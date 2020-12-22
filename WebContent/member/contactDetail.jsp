<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>



<style>
table {
    border-collapse: separate;
    border-spacing: 1px;
    text-align: left;
    line-height: 1.5;
    border-top: 1px solid #ccc;
  	margin : 20px 10px;
  }
  
th {
	width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}

 td {
	width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}

</style>

<script>
function del(num) {
	if(confirm("정말 문의사항을 삭제할까요?")) {
		location.href="contactdelete?num="+num;
		}
	}
</script>



<br/>
<h2 style="margin-left:20px"> 문의사항 내용 보기 </h2>

<table class="basic">

<tr>
	<td> 글번호 </td>
	<td> ${contact.num }</td>
	<td> 문의자 아이디 </td>
	<td> ${contact.userid }</td>  
</tr>

<tr>
	<td> 문의자 이름 </td>
	<td> ${contact.name }</td> 
	<td> 작성일 </td>
	<td> ${contact.reg_date }</td> 
</tr>


<tr>
	<td> 작성자 이메일 이메일 </td>
	<td>  ${contact.email }</td>
	<td> 작성자 연락처 </td>
	<td>  ${contact.phone }</td>
</tr>

<tr>
	<td> 문의사항 카테고리 </td>
	<td colspan="3">  ${contact.category } </td>
</tr>

<tr>
	<td> 내용 </td>
	<td colspan="3" style="height:200px">  ${contact.message }</td>
</tr>

<tr>
	<td colspan="4" align="center">
	<input type="button" value="글삭제" onclick="del('${contact.num }')" >
	<input type="button" value="글목록" onclick="location.href='contactlist'">
	</td>
</tr>

</table>

<%@ include file="../include/footer.jsp" %>
