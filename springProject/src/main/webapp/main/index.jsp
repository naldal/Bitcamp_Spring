<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<table border="1" width="100%">
<tr>
	<td colspan="2" align="center">
		<jsp:include page="../template/top.jsp"/>
	</td>
</tr>
<tr>
	<td width="25%" height="500" valign="top" align="center">
		<jsp:include page="../template/left.jsp"/>
	</td>
	<td valign="top">
		<jsp:include page="${display }"/>
	</td>
</tr>
<tr>
	<td colspan="2"><jsp:include page="../template/bottom.jsp"/></td>
</tr>
</table>
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>	
<script type="text/javascript" src="../js/member.js"></script>