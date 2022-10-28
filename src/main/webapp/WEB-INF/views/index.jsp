<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	
	<h1> <spring:message code="hi"></spring:message> </h1>
	<!-- code에 해당하는 키와 text 속성 둘다 없으면 code안에 텍스트 출력 -->
	<h1> <spring:message code="test" text="키가 없으면 출력되는 메시지"></spring:message> </h1>
	
	<c:if test="${not empty sessionScope.member }">
		<spring:message code="welcome" arguments="${sessionScope.member.id }"></spring:message>
		<spring:message code="welcome2" arguments="${sessionScope.member.id }, ${sessionScope.member.name }" argumentSeparator=","></spring:message>
	</c:if>
	
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