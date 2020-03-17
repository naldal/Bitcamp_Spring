<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="loginForm" method="post" action="/miniProject/member/login.do">
<table border="1" cellspacing="0" cellpadding="3">

<tr>
<td width="70" align="center">아이디</td>
<td>
	<input type="text" name="id" id="loginId">
	<div id="loginIdDiv"></div>
</td>
</tr>

<tr>
<td align="center">비밀번호</td>
<td>
	<input type="password" name="pwd" id="loginPwd">
	<div id="loginPwdDiv"></div>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input id="loginFormBtn" type="button" value="로그인">&emsp;
<input id="signUpBtn" type="button" value="회원가입" onclick="location.href='/miniProject/member/writeForm.do'">
</td>
</tr>

</table>
</form>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/miniProject/js/member.js"></script>
