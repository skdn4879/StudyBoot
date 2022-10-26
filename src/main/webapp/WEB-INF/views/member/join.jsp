<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>회원가입 페이지</h1>
	
	<form action="./join" method="post" id="joinForm">
		<div class="input-group mb-3">
		  <span class="input-group-text" id="idText">ID</span>
		  <input type="text" class="form-control" placeholder="ID" aria-label="id" aria-describedby="id" name="id" id="id">
		  <button type="button" class="btn btn-info" id="idCheckBtn">중복확인</button>
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pwText">PassWord</span>
		  <input type="password" class="form-control" placeholder="Password" aria-label="pw" aria-describedby="pw" name="pw" id="pw">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pwText">PWCheck</span>
		  <input type="password" class="form-control" placeholder="PWCheck" aria-label="pwcheck" aria-describedby="pwcheck" name="pwcheck" id="pwcheck">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="nameText">Name</span>
		  <input type="text" class="form-control" placeholder="Name" aria-label="name" aria-describedby="name" name="name" id="name">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="emailText">Email</span>
		  <input type="text" class="form-control" placeholder="Email" aria-label="email" aria-describedby="email" name="email" id="email">
		</div>
		<button type="button" class="btn btn-success" id="joinButton">Sign Up</button>
	</form>
	
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
	<script type="text/javascript" src="/js/memberAdd.js"></script>
	<script type="text/javascript" src="/js/util.js"></script>
</body>
</html>