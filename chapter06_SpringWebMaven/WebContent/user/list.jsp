<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<table id="table" border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th width="100">이름</th>
			<th width="100">아이디</th>
			<th width="100">비밀번호</th>
		</tr>
	</table>
	<br>
	
	<div class="search">
		<select name="searchOption" id="searchOption">
			<option value="">선택</option>
			<option value="name">이름</option>
			<option value="id">아이디</option>
		</select>
		<input type="text" id="searchText" name="searchText">
		<button id="searchBtn">검색</button>
	</div>
	
</body>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	

	$('#searchBtn').click(function () {
		if ($('#searchOption').val() == "") {
			alert("검색옵션을 선택하세요");
			// return false;
		} else {
			$('#table tr:gt(0)').remove();
			
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/search',
				data: 
					/* {'searchOption' : $('#searchOption'), 'searchText' : $('#searchText')} */
					/* 'searchOption=' + $('#searchOption').val()+'&searchText'+$('#searchText').val(), */
					JSON.stringify({
						'searchOption':$('#searchOption').val(),
						'searchText':$('#searchText').val()
					}),
				dataType: 'json',
				contentType: 'application/json;charset=UTF-8',
				success: function (data) {
					
					alert(JSON.stringify(data));
					
					$.each(data.list, function(index, items){
						$('<tr/>').append($('<td/>',{
							align: 'center',
							text: items.name
						})).append($('<td/>',{
							align: 'center',
							text: items.id
						})).append($('<td/>',{
							align: 'center',
							text: items.pwd
						})).appendTo('#table');
					});
				}
			});
		}
	});
	
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType: 'json',
		contentType: 'application/json;charset=UTF-8',
		success: function(data){
			/* alert(JSON.stringify(data)); */
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.name
				})).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.pwd
				})).appendTo('#table');
			});
		}
	});
	
});
</script>
</html>