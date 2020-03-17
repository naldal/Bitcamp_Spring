<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" width="50%" frame="hsides" rules="rows" cellpadding="3">
	
	<tr>
		<td rowspan="4"><img src="http://localhost:8081/miniProject/storage/${imageboardDTO.image1}"></td>
		<td>${imageboardDTO.imageName}</td>
	</tr>
	<tr>
		<td>${imageboardDTO.imagePrice}</td>
	</tr>
	<tr>
		<td>${imageboardDTO.imageQty}</td>
	</tr>
	<tr>
		<td>${imageboardDTO.imageQty * imageboardDTO.imagePrice}</td>
	</tr>
	<tr>
		<td height="200px" colspan="2">${imageboardDTO.imageContent}</td>
	</tr>
	<tr>
		<td><input type="button" value="목록" onclick="location.href='/miniProject/imageboard/imageboardList.do?pg=${pg}'"></td>
		
	</tr>
</table>