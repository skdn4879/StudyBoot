<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<!-- <form action="./write" method="post" enctype="multipart/form-data"> -->
		<form:form modelAttribute="qnaVO" method="post" enctype="multipart/form-data">
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  <form:input path="writer" cssClass="form-control" id="writer"/>
			  <form:errors path="writer"></form:errors>
			  <!-- <input type="text" class="form-control" id="writer" placeholder="writer" name="writer"> -->
			</div>
			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  <form:input path="title" cssClass="form-control" id="title"/>
			  <form:errors path="title"></form:errors>
			  <!-- <input type="text" class="form-control" id="title" placeholder="title" name="title"> -->
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <form:textarea path="contents" cssClass="form-control" id="contents"/>
			  <form:errors path="contents"></form:errors>
			  <!-- <textarea class="form-control" id="contents" rows="3" name="contents"></textarea> -->
			</div>
			
			<div class="mb-3" id="fileList">
			  <!-- <label for="files" class="form-label">File</label>
			  <input type="file" class="form-control" id="files" name="files"> -->
			</div>
			<div class="mb-3">
			  <button type="button" class="btn btn-info" id="fileAddBtn">FileAdd</button>
			</div>
			
			<button class="btn btn-outline-primary" type="submit">Write</button>
		</form:form>
		<%-- </form> --%>
	</div>
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	<script type="text/javascript">
		$("#contents").summernote();
	</script>
	<script type="text/javascript" src="/js/qnaWrite.js"></script>
	<script type="text/template" id="fileInputTemp">
		<div class="container input-group mb-3">
			<label for="files" class="form-label" style="font-size: 1.3rem; font-weight: bold;">File</label>
			<input type="file" class="form-control" id="files" name="files">
			<button type="button" class="btn btn-danger fileRemoveBtn">파일삭제</button>
		</div>
	</script>
</body>
</html>