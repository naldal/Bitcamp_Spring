$('#writeFormBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	$('#repwdDiv').empty();
	
	if($('input[name=name]').val()==''){
		$('#nameDiv').text('이름을 입력하세요');
		$('#nameDiv').css('color', 'red');
		$('#nameDiv').css('font-size', '8pt');
		$('#nameDiv').css('font-weignt','bold');
	} else if($('#id').val()==''){
		$('#idDiv').text('아이디를 입력하세요');
		$('#idDiv').css('color', 'red');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('font-weignt','bold');
	} else if($('#pwd').val()==''){
		$('#pwdDiv').text('비밀번호를 입력하세요');
		$('#pwdDiv').css('color', 'red');
		$('#pwdDiv').css('font-size', '8pt');
		$('#pwdDiv').css('font-weignt','bold');
	} else if($('#pwd').val()!=$('#repwd').val()){
		$('#repwdDiv').text('비밀번호가 일치하지 않습니다.');
		$('#repwdDiv').css('color', 'red');
		$('#repwdDiv').css('font-size', '8pt');
		$('#repwdDiv').css('font-weignt','bold');
	} else if($('#id').val()!=$('#idCheck').val()) {
		$('#idDiv').text('중복확인을 해주세요');
		$('#idDiv').css('color', 'red');
		$('#idDiv').css('font-size', '8pt');
		$('#idDiv').css('font-weignt','bold');
	} else {
		$('form[name=writeForm]').submit();
	}
	
});

$('#imageUpload').click(function(){
	
	$('#imgidDiv').empty();
	$('#imgnameDiv').empty();
	$('#imgpriceDiv').empty();
	$('#imgqtyDiv').empty();
	$('#imgcontentDiv').empty();
	
	if($('#imageid').val()==''){
		$('#imgidDiv').text('이미지 아이디를 입력하세요');
		$('#imgidDiv').css('color', 'red');
		$('#imgidDiv').css('font-size', '8pt');
		$('#imgidDiv').css('font-weignt','bold');
	} else if($('#imagename').val()==''){
		$('#imgnameDiv').text('이미지 이름을 입력하세요');
		$('#imgnameDiv').css('color', 'red');
		$('#imgnameDiv').css('font-size', '8pt');
		$('#imgnameDiv').css('font-weignt','bold');
	} else if($('#imageprice').val()==''){
		$('#imgpriceDiv').text('가격을 입력하세요');
		$('#imgpriceDiv').css('color', 'red');
		$('#imgpriceDiv').css('font-size', '8pt');
		$('#imgpriceDiv').css('font-weignt','bold');
	} else if($('#imageqty').val()==''){
		$('#imgqtyDiv').text('수량을 입력하세요.');
		$('#imgqtyDiv').css('color', 'red');
		$('#imgqtyDiv').css('font-size', '8pt');
		$('#imgqtyDiv').css('font-weignt','bold');
	} else if($('imagecontent').val()=='') {
		$('#imgcontentDiv').text('내용을 입력하세요');
		$('#imgcontentDiv').css('color', 'red');
		$('#imgcontentDiv').css('font-size', '8pt');
		$('#imgcontentDiv').css('font-weignt','bold');
	} else {
		$('form[name=imageBoardForm]').submit();
	}
	
})

$('#boardwriteBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val()==''){
		$('#subjectDiv').text('제목을 입력하세요');
		$('#subjectDiv').css('color', 'red');
		$('#subjectDiv').css('font-size', '8pt');
		$('#subjectDiv').css('font-weignt','bold');
	} else if($('#content').val()==''){
		$('#contentDiv').text('내용을 입력하세요');
		$('#contentDiv').css('color', 'red');
		$('#contentDiv').css('font-size', '8pt');
		$('#contentDiv').css('font-weignt','bold');
	} else {
		$('form[name=boardWriteForm]').submit();
	}
});

function checkPost() {
	window.open("/miniProject/member/checkPost.do", "", "width=400 height=400 scrollbars=yes");
}

function idCheck2() {
	let sId = document.writeForm.id.value;
	if(sId=="") {
		alert("먼저 아이디를 입력하세요.");
	} else {
		window.open("/miniProject/member/checkId.do?id="+sId
		, ""
		, "width=300 height=100 left=500 top=100");
	}
}

function checkIdClose(id) {
	opener.writeForm.id.value = id;
	/*alert(id);*/
	opener.writeForm.idCheck.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}

if($('#fail').val()=="1") {
	$('#loginChk').empty();
	$('#loginChk').text('로그인 실패')
				  .css('color', 'red')
				  .css('font-size', '8pt')
				  .css('font-weignt','bold');
}


$('#loginFormBtn').click(function(){
	$('#loginIdDiv').empty();
	$('#loginPwdDiv').empty();
	
	if($('#loginId').val()==''){
		$('#loginIdDiv').text('아이디를 입력')
						.css('color', 'red')
						.css('font-size', '8pt')
						.css('font-weignt','bold');
		
	} else if ($('#loginPwd').val()==''){
		$('#loginPwdDiv').text('비밀번호를 입력')
		.css('color', 'red')
		.css('font-size', '8pt')
		.css('font-weignt','bold');
	} else {
		$('form[name=loginForm]').submit();
	}
});


function checkModifyForm() {
	if(document.getElementById('id').value==""){
		alert("이름을 입력하세요.");
	} else if(document.getElementById('pwd').value=="") {
		alert("비밀번호를 입력하세요.")
	} else if(document.getElementById('pwd').value != document.getElementById('repwd').value) {
		alert("비밀번호가 일치하지 않습니다.")
	} else {
		document.modifyForm.submit();
	}
}

function checkBoardWriterForm() {
	if(document.getElementById('subject').value=="") {
		alert("제목을 입력하세요.");
	} else if(document.getElementById('content').value=="") {
		alert("내용을 입력하세요.");
	} else {
		document.boardWriteForm.submit();
	}
}