<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Update Page</h1>
	
	<div>
		<form action="./update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" id="num" value="${qnaVO.num }">
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  <input type="text" class="form-control" id="writer" placeholder="writer" name="writer" value="${qnaVO.writer }" readonly="readonly">
			</div>
			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  <input type="text" class="form-control" id="title" placeholder="title" name="title" value="${qnaVO.title }">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" id="contents" rows="3" name="contents"></textarea>
			</div>
			
			<div class="mb-3" id="fileList">
			  <c:forEach items="${qnaVO.qnaFiles }" var="fileVO">
			  	<p>
			  		${fileVO.oriName }
			  		<button class="btn btn-danger deleteFile" type="button" data-num="${fileVO.fileNum }">삭제</button>
			  	</p>
			  </c:forEach>
			</div>
			<div class="mb-3">
			  <button type="button" class="btn btn-info" id="fileAddBtn">FileAdd</button>
			</div>
			
			<button class="btn btn-outline-primary" type="submit">Write</button>
		</form>
	</div>
	
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	<script type="text/javascript">
		$("#contents").summernote();
		$("#contents").summernote('code', '${qnaVO.contents }');
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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