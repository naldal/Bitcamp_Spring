<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
#subjectA:link { color: black; text-decoration: none; }
#subjectA:visited { color: black; text-decoration: none; }
#subjectA:hover { color: blue; text-decoration: underline; }
#subjectA:active { color: black; text-decoration: none; }

#paging {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
#currentPaging {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
</style>

<input type="hidden" id="pg" value="${pg}">

<table id="boardListTable" border="1" cellpadding="5" frame="hsides" rules="rows">
 <tr>
	<th width="70">글번호</th>
	<th width="100">제목</th>
	<th width="200">작성자</th>
	<th width="300">작성일</th>
	<th width="100">조회수</th>
 <tr>
</table>

<div id="boardPagingDiv" style="display:inline-block; width: 700px; text-align: center;">
${boardPaging.pagingHTML}</div>


<script type="text/javascript">
function isLogin1(id,seq,pg){
	if(id=='')
		alert("먼저 로그인하세요");
	else
		location.href="boardView.do?seq="+seq+"&pg="+pg;
}
</script>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script>
	$.ajax({
		type: 'post',
		url: '/springProject/board/getBoardList',
		data: 'pg='+$('#pg').val(),
		dataType:'json',
		success: function(data){		
			 $.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
				})).append($('<td/>',{
				
					}).append($('<a/>',{
						href: '#',
						text: items.subject,
						id: 'subjectA',
						class: items.seq+''
					}))
					
				).append($('<td/>',{
					align: 'center',
					text: items.id
				})).append($('<td/>',{
					align: 'center',
					text: items.logtime
				})).append($('<td/>',{
					align: 'center',
					text: items.hit
				})).appendTo($('#boardListTable'));
				
				//답글
				for(i=0; i<=items.lev; i++){
					$('.'+items.seq).before('&emsp;');
				}//for
				if(items.pseq!=0){
					$('.'+items.seq).before($('<img/>',{
						src : '../img/reply.gif'
					}));
				}
				
				
			}); //each
			
			//페이징 처리
			$('#boardPagingDiv').html(data.boardPaging.pagingHTML);
			
			//로그인 여부
			$('#boardListTable').on('click', '#subjectA', function(){
				if(data.memId == null) {
					alert('먼저 로그인하세요');
				} else {
					let seq = $(this).attr('class');
					let pg = data.pg;
					location.href = '/springProject/board/boardView?seq='+seq+'&pg='+pg;
					
				}
			});
		}
	});
</script>
	
<script type="text/javascript" src="../js/board.js"></script>