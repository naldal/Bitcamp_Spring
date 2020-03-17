<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:if test="${sessionScope.memId eq null}">
	<jsp:include page="../member/loginForm.jsp" />
	<input type="hidden" id="fail" value="${fail}">
	<div style="margin-top: 8px" id='loginChk' align="center"></div>
</c:if>
<c:if test="${sessionScope.memId ne null}">
	<jsp:include page="../member/loginOk.jsp" />
</c:if>