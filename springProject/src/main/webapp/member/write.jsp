<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>
<sql:update dataSource="jdbc/oracle" var="su">
	insert into member values('${param.name}', '${param.id}', '${param.pwd}' , '${param.gender}', 
	'${param.email1}', '${param.email2}', '${param.tel1}', '${param.tel2}', '${param.tel3}', 
	'${param.zipcode}', '${param.addr1}', '${param.addr2}', '${param.logtime}')
</sql:update>
<c:if test="${su==1 }">
DB 저장 성공
</c:if>

<c:if test="${su==0 }">DB 저장 실패</c:if>
