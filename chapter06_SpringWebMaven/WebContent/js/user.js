
$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();

	if($('#name').val()==""){
		$('#nameDiv').text('이름을 입력하세요');
		$('#nameDiv').css('font-size', '8px');
		$('#nameDiv').css('color','red');
	} else if($('#id').val()==''){
		$('#idDiv').text('아이디를 입력하세요');
		$('#idDiv').css('font-size', '8px'); 
		$('#idDiv').css('color','red');
	} else if($('#pwd').val()==''){
		$('#pwdDiv').text('패스워드를 입력하세요');
		$('#pwdDiv').css('font-size', '8px');
		$('#pwdDiv').css('color','red');
	} else {
		$.ajax({
			type: 'POST',
			url: '/chapter06_SpringWebMaven/user/write',
			data: $('#writeForm').serialize(),
			success: function(){
				alert('회원가입을 축하합니다.');
			}
		});
	}
});
