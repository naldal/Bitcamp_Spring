$('#boardReplyBtn').click(function(){
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
		document.forms[0].submit();
	}
});