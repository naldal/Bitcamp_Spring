<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h3>답글쓰기</h3><br>
<form id="boardReplyForm" name="boardReplyForm" method="post" action="/springProject/board/boardReply">
<input type="hidden" name="pseq" value="${pseq}">
<input type="hidden" name="pg" value="${pg}">
	<table border="1" cellspacing="0" cellpadding="3">
	<tr>
		<td align="center" width="70">제목</td> 
		<td>
			<input type="text" id="subject" name="subject" id="subject" placeholder="제목 입력"  size="30">
			<div id="subjectDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td align="center">내용</td>
		<td>
			<textarea width="450" id="content" name="content" id="content" cols="55" rows="20"></textarea>
			<div id="contentDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="답글쓰기" id="boardFormBtn">&emsp;
			<input type="reset" value="다시작성">
		</td>
	</tr>
	
	</table>
</form>
</body>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>	
<script type="text/javascript">
$(document).ready(function(){
	$('#boardFormBtn').click(function(){
		if($('#subject').val()==''){
			$('#subjectDiv').text('제목을 입력하십셔').css('font-size', '8pt').css('color', 'red');
		} else if ($('#content').val()=='') {
			$('#contentDiv').text('내용을 입력하십셔').css('font-size', '8pt').css('color', 'red');
		} else {
			$('#boardReplyForm').submit();
		}
	});
});
</script>