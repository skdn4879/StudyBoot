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
	
	<form action="./join" method="post">
		<div class="input-group mb-3">
		  <span class="input-group-text" id="id">ID</span>
		  <input type="text" class="form-control" placeholder="ID" aria-label="id" aria-describedby="id" name="id">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="pw">PassWord</span>
		  <input type="password" class="form-control" placeholder="pw" aria-label="pw" aria-describedby="pw" name="pw">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="name">Name</span>
		  <input type="text" class="form-control" placeholder="name" aria-label="name" aria-describedby="name" name="name">
		</div>
		<div class="input-group mb-3">
		  <span class="input-group-text" id="email">Email</span>
		  <input type="text" class="form-control" placeholder="email" aria-label="email" aria-describedby="email" name="email">
		</div>
		<button type="submit" class="btn btn-success">Sign Up</button>
	</form>
</body>
</html>