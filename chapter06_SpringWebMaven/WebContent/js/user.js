
$('#writeBtn').click(function () {
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();

	if ($('#name').val() == "") {
		$('#nameDiv').text('이름을 입력하세요');
		$('#nameDiv').css('font-size', '8px');
		$('#nameDiv').css('color', 'red');
	} else if ($('#id').val() == '') {
		$('#idDiv').text('아이디를 입력하세요');
		$('#idDiv').css('font-size', '8px');
		$('#idDiv').css('color', 'red');
	} else if ($('#pwd').val() == '') {
		$('#pwdDiv').text('패스워드를 입력하세요');
		$('#pwdDiv').css('font-size', '8px');
		$('#pwdDiv').css('color', 'red');
	} else {
		$.ajax({	//most important point //cross browsing x
			type: 'POST',
			url: '/chapter06_SpringWebMaven/user/write',
			data: $('#writeForm').serialize(),
			success: function () {
				alert('회원가입을 축하합니다.');
			}
		});
	}
});

$('#id').focusout(function () {
	$('#idDiv').empty();

	if ($('#id').val() == "") {
		$('#idDiv').text('필수 정보입니다.');
		$('#idDiv').css('color', 'magenta');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('font-weight', 'bolder');
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/checkId',
			data: 'id=' + $('#id').val(),
			dataType: 'text',
			success: function (data) {
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
				}
			},
			error: function (err) {
				console.log(err);
				alert('실패');
			}
		});
	}
});

$('#modifyForm').hide();
$('#searchBtn').click(function () {
	$('#resultDiv').empty();

	if ($('#searchId').val() == "") {
		$('#resultDiv').text('먼저 아이디를 입력하라고 ㅋㅋ 아 ㅋㅋ');
		$('#resultDiv').css('color', 'red');
		$('#resultDiv').css('font-size', '10pt');
		$('#resultDiv').css('font-weight', 'bolder');
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id=' + $('#searchId').val(),
			dataType: 'json',
			success: function (data) {
				if ($.isEmptyObject(data)) {
					$('#resultDiv').text('병신임?');
					$('#resultDiv').css('color', 'red');
					$('#resultDiv').css('font-size', '10pt');
					$('#resultDiv').css('font-weight', 'bolder');
				} else {
					$('#modifyForm').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
				}
			},
			error: function (err) {
				console.log(err);
				alert('실패');
			}
		});
	}
});

$('#resetBtn').click(function(){
	$('#name').empty();
});
