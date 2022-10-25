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
	
	<form action="./login" method="post">
		<div class="input-group mb-3">
		  <span class="input-group-text" id="id">ID</span>
		  <input type="text" class="form-control" placeholder="ID" aria-label="id" aria-describedby="id" name="id">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pw">PW</span>
		  <input type="password" class="form-control" placeholder="PW" aria-label="pw" aria-describedby="pw" name="pw">
		</div>
		<button type="submit" class="btn btn-primary">Sign In</button>
	</form>
</body>
</html>