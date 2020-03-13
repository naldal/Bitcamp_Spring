<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름 : ${sungJukDTO.name} <br>
합계 : ${sungJukDTO.tot}	<br>
평균 : <fmt:formatNumber pattern="#.##">${sungJukDTO.avg}</fmt:formatNumber>
</body>
</html>