<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>회원가입 페이지</h1>
	
	<form:form modelAttribute="memberVO" method="post" id="joinForm">
		<div class="input-group mb-3">
		  <span class="input-group-text" id="idText">ID</span>
		  <form:input path="id" cssClass="form-control" id="id"/>
		  <div id="inputIdResult">
		  	<form:errors path="id"></form:errors>
		  	<!-- JS와 검증 메시지가 겹칠 경우 inputIdResult.html을 사용하여 둘 중 하나만 출력하게 할 수 있다. -->
		  </div>
		  <!-- <input type="text" class="form-control" placeholder="ID" aria-label="id" aria-describedby="id" name="id" id="id"> -->
		  <button type="button" class="btn btn-info" id="idCheckBtn">중복확인</button>
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pwText">PassWord</span>
		  <form:password path="pw" cssClass="form-control" id="pw"/>
		  <form:errors path="pw"></form:errors>
		  <!-- <input type="password" class="form-control" placeholder="Password" aria-label="pw" aria-describedby="pw" name="pw" id="pw"> -->
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pwText">PWCheck</span>
		  <form:password path="pwcheck" cssClass="form-control" id="pwcheck"/>
		  <form:errors path="pwcheck"></form:errors>
		  <!-- <input type="password" class="form-control" placeholder="PWCheck" aria-label="pwcheck" aria-describedby="pwcheck" name="pwcheck" id="pwcheck"> -->
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="nameText">Name</span>
		  <form:input path="name" cssClass="form-control" id="name"/>
		  <form:errors path="name"></form:errors>
		  <div id="inputNameResult">
		  	${name }
		  </div>
		 <!-- <input type="text" class="form-control" placeholder="Name" aria-label="name" aria-describedby="name" name="name" id="name"> -->
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="emailText">Email</span>
		  <form:input path="email" cssClass="form-control" id="email"/>
		  <form:errors path="email"></form:errors>
		  <!-- <input type="text" class="form-control" placeholder="Email" aria-label="email" aria-describedby="email" name="email" id="email"> -->
		</div>
		<!-- form:button은 무조건 type이 submit -->
		<%-- <form:button></form:button> --%>
		<!-- <button type="button" class="btn btn-success" id="joinButton">Sign Up</button> -->
		<button type="submit" class="btn btn-success" id="joinButton">Sign Up</button>
	</form:form>
	
	<h1 id="alertText" style="color : red;"></h1>
	
	<div>
		<div>
			ALL <input type="checkbox" id="all">
		</div>
		<div>
			동의1 <input type="checkbox" class="check">
			<div>약관1</div>
		</div>
		<div>
			동의2 <input type="checkbox" class="check">
			<div>약관2</div>
		</div>
		<div>
			동의3 <input type="checkbox" class="check">
			<div>약관3</div>
		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript" src="/js/memberAdd.js"></script>
	<script type="text/javascript" src="/js/util.js"></script>
</body>
</html>