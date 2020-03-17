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

<table border="1" cellpadding="5" frame="hsides" rules="rows">
	<th>글번호</th><!-- 가운데, 굵게 -->
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>조회수</th>

<c:if test="${list != null }">
	<c:forEach var="boardDTO" items="${list }">
		<tr>
			<td width="70" align="center">${boardDTO.seq}</td>
			<td width="300">
			<a href="javascript:isLogin1('${memId}', ${boardDTO.seq}, ${pg})" id="subjectA">
			<c:forEach var="i" begin="1" end="${boardDTO.lev}" step="1">
				&emsp;
			</c:forEach>
			<c:if test="${boardDTO.pseq ne 0}">
			<img src="../img/reply.gif">
			</c:if>
			${boardDTO.subject}
			</a>
			</td>
			<td width="100" align="center">${boardDTO.id}</td>
			<td width="200" align="center">${boardDTO.logtime}</td>
			<td width="70" align="center">${boardDTO.hit}</td>
		</tr>
	</c:forEach>
</c:if>
</table>

<div style="display:inline-block; width: 700px; text-align: center;">
${boardPaging.pagingHTML}</div>

<script type="text/javascript">
function isLogin1(id,seq,pg){
	if(id=='')
		alert("먼저 로그인하세요");
	else
		location.href="boardView.do?seq="+seq+"&pg="+pg;
}
</script>





















