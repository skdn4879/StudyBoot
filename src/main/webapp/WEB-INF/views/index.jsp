<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/index.css" rel="stylesheet">
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Index Page</h1>
	<img src="/images/title3.jpg">
	<a href="./qna/list">QNA</a>
	<a href="./member/join">회원가입</a>
	<c:if test="${sessionScope.member == null }">
		<a href="./member/login">로그인</a>
	</c:if>
	<c:if test="${sessionScope.member != null }">
		<a href="./member/logout">로그아웃</a>
	</c:if>
</body>
</html>