<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<form name="writeForm" method="post" action="/springProject/member/write">
		<table border="1" cellspacing="0" cellpadding="3">

			<tr>
				<td width="70" align="center">이름</td>
				<td>
					<input type="text" name="name" id="name" placeholder="이름 입력">
					<div id="nameDiv"></div>
				</td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td>
					<input type="text" name="id" id="id" placeholder="아이디 입력">
					<input type="hidden" id="check" name="check" value="">
					<div id="idDiv"></div>
				</td>
			</tr>

			<tr>
				<td align="center">비밀번호</td>
				<td>
					<input type="password" id="pwd" name="pwd">
					<div id="pwdDiv"></div>
				</td>
			</tr>

			<tr>
				<td align="center">재확인</td>
				<td>
					<input type="password" id="repwd" name="repwd">
					<div id="repwdDiv"></div>	
				</td>
			</tr>

			<tr>
				<td align="center">성별</td>
				<td><input type="radio" name="gender" value="0" checked>남자
					<input type="radio" name="gender" value="1">여자
				</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1" size="15">
				 	@
				 	<input type="text" name="email2" list="email2" placeholder="직접입력">
					<datalist id="email2">
						<option value="naver.com">
						<option value="gmail.com">
						<option value="daum.net">
					</datalist></td>
			</tr>

			<tr>
				<td align="center">핸드폰</td>
				<td>
				<select name="tel1" style="width:70px;">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="017">017</option>
				<option value="018">018</option>
				</select>
				-
				<input type="text" name="tel2" size="5">
				-
				<input type="text" name="tel3" size="5">
				</td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td>
				<input type="text" name="zipcode" id="zipcode" size="6" readonly>
				<input type="button" value="우편번호 검색" id="checkPostBtn"><br>
				<input type="text" name="addr1" id="addr1" placeholder="주소" size="50" readonly><br>
				<input type="text" name="addr2" id="addr2" placeholder="상세 주소" size="50">
 				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<!-- <input type="button" value="회원가입" onclick="checkWriteForm()">&emsp; -->
				<input id="writeFormBtn" type="button" value="회원가입">
				<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>	
<script type="text/javascript" src="../js/member.js"></script>

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){	
	$('#id').focusout(function(){
		if($('#id').val()==''){
			$('#idDiv').text('먼저 아이디를 입력하세요.');
		} else {
			$.ajax({
				type: 'post',
				url : '/springProject/member/checkId',
				data : 'id='+$('#id').val(),
				dataType : 'text',
				success : function(data){
					if (data == 'exist') {
						$('#idDiv').text('사용 불가능')
						$('#idDiv').css('color', 'magenta');
						$('#idDiv').css('font-size', '8pt');
						$('#idDiv').css('font-weight', 'bolder');
					} else if (data == 'non_exist') {
						$('#idDiv').text('사용 가능')
						$('#idDiv').css('color', 'blue');
						$('#idDiv').css('font-size', '8pt');
						$('#idDiv').css('font-weight', 'bolder');
						$('#check').val($('#id').val());
					}
				}
			});
		}
	});
	
	$('#checkPostBtn').click(function(){
		window.open('/springProject/member/checkPost', '', 'width=400 height=400 scrollbar=yes');
	});
	
});
</script>
