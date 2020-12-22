<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

<!-- 예제 시작 -->

<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

우편번호 : <input type="text" name="zip" style="width:80px; height:26px;" />
<button type="button" style="width:60px; height:32px;" onclick="openZipSearch()">검색</button><br>
주소 : <input type="text" name="addr1" style="width:300px; height:30px;" readonly /><br>
상세 : <input type="text" name="addr2" style="width:300px; height:30px;" />

<script>

function openZipSearch() {
	new daum.Postcode({
		oncomplete: function(data) {
			$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
			$('[name=addr1]').val(data.address);
			$('[name=addr2]').val(data.buildingName);
		}
	}).open();
}

</script>

<!-- 예제 종료 -->


</body>
</html>