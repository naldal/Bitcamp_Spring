<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ page import="board.dao.BoardDAO"%>
<%@ page import="board.bean.BoardDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"></jsp:useBean> --%>

<style type="text/css">
.contents {
	white-space:pre-wrap;
	word-break: break-all;
}
</style>

	<form name="boardViewForm" method="post">
	<input type="hidden" name="seq" value="${requestScope.boardDTO.seq}">
	<input type="hidden" name="pg" value="${pg}">
	<input type="hidden" name="subject" value="${requestScope.boardDTO.subject}">
	<input type="hidden" name="content" value="${requestScope.boardDTO.content}">
	
	<table border="1" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<td colspan="3">
				<h3>${boardDTO.subject }</h3>
			</td>
		</tr>
		<tr>
			<td width="150">글번호 : ${requestScope.boardDTO.seq}</td>
			<td width="150">작성자 : ${requestScope.boardDTO.id}</td>
			<td width="150">조회수 : ${requestScope.boardDTO.hit}</td>
		</tr>

		<tr>
			<td colspan="3" height="200" valign="top">
			<pre class="contents">${requestScope.boardDTO.content}</pre>
			</td>
		</tr>

	</table>
	<input type="button" value="목록" onclick="location.href='boardList.do?pg=${pg}'">
	<input type="button" value="답글" 
	onclick="location.href='boardReplyForm.do?pseq=${requestScope.boardDTO.seq}&pg=${pg}'">
	<c:if test = "${memId == requestScope.boardDTO.id}">
		<input type="button" value="글수정" onclick="mode(1)">
		<input type="button" value="글삭제" onclick="mode(2)">
	</c:if>
	</form>
	
<script type="text/javascript">
function mode(num) {
	if(num==1) {
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardModifyForm.do';
		document.boardViewForm.submit();
	} else if(num==2) {
		document.boardViewForm.method = 'post';
		document.boardViewForm.action = 'boardDelete.do?seq=${requestScope.boardDTO.seq}&pg=${pg}';
		document.boardViewForm.submit();
	}
}
</script>
