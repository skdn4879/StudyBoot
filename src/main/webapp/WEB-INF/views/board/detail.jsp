<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>Detail Page</h1>
	<a class="btn btn-outline-info" role="button" href="./update?num=${qnaVO.num }">수정</a>
	
	<h3>${qnaVO.num }</h3>
	<h3>${qnaVO.writer }</h3>
	<h3>${qnaVO.title }</h3>
	<h3>${qnaVO.contents }</h3>
	<h3>${qnaVO.hit }</h3>
	<h3>${qnaVO.regDate }</h3>
	<h3>${qnaVO.ref }</h3>
	<h3>${qnaVO.step }</h3>
	<h3>${qnaVO.depth }</h3>
	
	<c:forEach items="${qnaVO.qnaFiles }" var="file">
		<h3>${file.fileName }</h3>
		<h3>${path }${file.fileName}</h3>
		<img alt="" src="/file/qna/${file.fileName }">
		<a href="/fileDown/qna?fileNum=${file.fileNum }">${file.oriName } 사진 다운로드</a>
		<img alt="" src="/file/notice/testImage.jpg">
		<a href="/fileDown/notice?fileNum=${file.fileNum }">노티스 사진 다운로드</a>
		<!-- file로 시작하지 않으니 WebConfig의 regisry가 가로채지 않음 -->
	</c:forEach>
	
</body>
</html>