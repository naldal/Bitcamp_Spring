<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
	td {
		align:center
	}
	
	#currentPaging{
		color: red;
		text-decoration: underline;
	}
	
	#paging{
		color: black;
		text-decoration: none;
		cursor: pointer;
	}
</style>
<form name="imageboardListForm" method="post" action="imageboardDelete.do">
<table border="1" frame="hsides" rules="rows">

	<th width="70">
		<input type="checkbox" id="all" onclick="checkAll()">글번호
	</th>
	<th width="200">이미지</th>
	<th width="100">상품평</th>
	<th width="100">단가</th>
	<th width="70">개수</th>
	<th width="100">합계</th>

<c:forEach var="imageboardDTO" items='${list}'>
	<tr>
		<td>
			<input type="checkbox" name="check" value=${imageboardDTO.seq}>
			${imageboardDTO.seq}
		</td>
		<td>
			<a href="#" onclick="location.href='imageboardView.do?seq=${imageboardDTO.seq}&pg=${pg}'">
			<img width="50px" height="50px" src="http://localhost:8081/miniProject/storage/${imageboardDTO.image1}">
		</a>
		</td>
		<td>
			${imageboardDTO.imageName}
		</td>
		<td>
			<fmt:formatNumber pattern="#,###원">${imageboardDTO.imagePrice}</fmt:formatNumber>
		</td>
		<td>
			${imageboardDTO.imageQty}
		</td>
		<td>	
			<fmt:formatNumber pattern="#,###원">${imageboardDTO.imagePrice * imageboardDTO.imageQty}</fmt:formatNumber>
		</td>
		
	</tr>
</c:forEach>
</table>
</form>

<div style="float:left;"><input type="button" value="선택삭제" onclick="choiceDelete()"></div>
<div style="float:left; width:200px; text-align: center;">${imageboardPaging.pagingHTML}</div>

<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function checkAll(){
	//alert(document.getElementById("all").checked);
	//alert(document.getElementsByName("check").length)
	
	let check = document.getElementsByName("check");
	if(document.getElementById("all").checked){
		for(i=0; i<check.length; i++){
			check[i].checked = true;
		} 
	}else {
		for(i=0; i<check.length; i++){
			check[i].checked = false;
			}
		}
	}
	
function choiceDelete(){
	let check = document.getElementsByName("check");
	let count=0;
	for(i=0; i<check.length; i++){
		if(check[i].checked) {
			count++;
		}
	}

	if(count==0){
		alert("항목을 선택하세요");
	} else {
		if(confirm("정말로 삭제하시겠습니까?")){
			document.imageboardListForm.submit();
		}
	}
}

function imageboardPaging(pg){
	location.href="imageboardList.do?pg="+pg;
}
</script>

