<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>로그인 페이지</h1>
	
	<div>
		<h3>${param.message }</h3>
		<h3>${param.error }</h3>
		<h3>${msg }</h3>
	</div>
	
	<form action="./login" method="post">
		<div class="input-group mb-3">
		  <span class="input-group-text" id="id">ID</span>
		  <input type="text" class="form-control" placeholder="ID" aria-label="id" aria-describedby="id" name="id" value="${cookie.userId.value }">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pw">PW</span>
		  <input type="password" class="form-control" placeholder="PW" aria-label="pw" aria-describedby="pw" name="pw">
		</div>
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="on" id="flexCheckDefault" name="rememberId">
		  <label class="form-check-label" for="flexCheckDefault">
		    아이디 기억하기
		  </label>
		</div>
		<button type="submit" class="btn btn-primary">Sign In</button>
	</form>
	
	<script type="text/javascript">
		history.replaceState({}, null, location.pathname)
	</script>
	
</body>
</html>