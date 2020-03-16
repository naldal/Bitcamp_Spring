<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	수정할 아이디 입력 :
	<input type="text" id="searchId">
	<input type="button" id="searchBtn" value="검색">
	<br>

	<div id="resultDiv"></div>
	<br>

	<div>
		<form id="modifyForm" method="post">
			<table border="1" cellspacing="0" cellpadding="3">

				<tr>
					<td width="70" align="center">이름</td>
					<td><input type="text" name="name" id="name"
						placeholder="이름 입력">
				</tr>

				<tr>
					<td align="center">아이디</td>
					<td><input type="text" name="id" id="id" placeholder="아이디 입력"
						readonly="readonly">
				</tr>

				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" id="pwd" name="pwd">
				</tr>

				<tr>
					<td colspan="2" align="center">
					<input type="button" id="modifyBtn" value="수정">
					<input type="reset"	id="resetBtn" value="다시작성">
					<input type="button" value="목록" onclick=""></input>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/user.js"></script>
</html>