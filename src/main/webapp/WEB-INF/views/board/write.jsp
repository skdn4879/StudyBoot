<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Board Write Page</h1>
	
	<div>
		<form action="./write" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  <input type="text" class="form-control" id="writer" placeholder="writer" name="writer">
			</div>
			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  <input type="text" class="form-control" id="title" placeholder="title" name="title">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" id="contents" rows="3" name="contents"></textarea>
			</div>
			
			<div class="mb-3">
			  <label for="files" class="form-label">File</label>
			  <input type="file" class="form-control" id="files" name="files">
			</div>
			<div class="mb-3">
			  <label for="files" class="form-label">File</label>
			  <input type="file" class="form-control" id="files" name="files">
			</div>
			
			<button class="btn btn-outline-primary" type="submit">Write</button>
		</form>
	</div>
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
</body>
</html>