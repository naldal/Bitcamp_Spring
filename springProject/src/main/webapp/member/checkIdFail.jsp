<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="/mvcMember/member/checkId.do">
${requestScope.id }는(은) 사용 불가능<br><br>
아이디
<input type="text" name="id" size="7">
<input type="submit" value="중복체크">
</form>
