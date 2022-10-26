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
	
	<button id="btn">CLICK</button>
	
	<button class="buttons">buttons</button>
	<button class="buttons">buttons</button>
	<button class="buttons">buttons</button>
	
	<div id="test"></div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script type="text/javascript" src="/js/test.js"></script>
</body>
</html>