<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 결과 : ${requestScope.x} + ${requestScope.y} = ${requestScope.x + requestScope.y} --%>

${sumDTO.x }+${sumDTO.y } = ${sumDTO.x + sumDTO.y }
</body>
</html>