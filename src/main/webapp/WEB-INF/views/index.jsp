<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	
	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="Principal" var="member"/>
		<spring:message code="welcome" arguments="${member.id }"></spring:message>
		<spring:message code="welcome2" arguments="${member.id }, ${member.name }" argumentSeparator=","></spring:message>
	</sec:authorize>
	
	<img src="/images/title3.jpg">
	<a href="./qna/list">QNA</a>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="./member/join">회원가입</a>
		<a href="./member/login">로그인</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<a href="./member/mypage">마이페이지</a>
		<a href="./member/logout">로그아웃</a>
		
		<sec:authorize url="/admin">
			<a href="/admin">A</a>
		</sec:authorize>
		
		<sec:authorize access="hasAnyRole('ADMIN', 'MANAGER')">
			<a href="/manager">M</a>
		</sec:authorize>
		
	</sec:authorize>
	
	<button id="btn">CLICK</button>
	
	<button class="buttons">buttons</button>
	<button class="buttons">buttons</button>
	<button class="buttons">buttons</button>
	
	<div id="test"></div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script type="text/javascript" src="/js/test.js"></script>
</body>
</html>