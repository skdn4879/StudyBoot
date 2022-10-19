<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>
	<h1>List Page</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>num</th>
				<th>writer</th>
				<th>title</th>
				<th>contents</th>
				<th>hit</th>
				<th>regDate</th>
				<th>ref</th>
				<th>step</th>
				<th>depth</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${qnaList }" var="qnaVO">
				<tr>
					<td>${qnaVO.num }</td>
					<td>${qnaVO.writer }</td>
					<td>${qnaVO.title }</td>
					<td>${qnaVO.contents }</td>
					<td>${qnaVO.hit }</td>
					<td>${qnaVO.regDate }</td>
					<td>${qnaVO.ref }</td>
					<td>${qnaVO.step }</td>
					<td>${qnaVO.depth }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:if test="${pager.pre }">
		<a href="./list?page=${pager.startNum - 1 }">Pre</a>
	</c:if>
	<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" step="1" var="i">
		<a href="./list?page=${i }">${i}</a>
	</c:forEach>
	<c:if test="${pager.next }">
		<a href="./list?page=${pager.lastNum + 1 }">Next</a>
	</c:if>
	
	<a href="./write" class="btn btn-outline-danger" role="button">Write</a>
	
	<script type="text/javascript">
		let result = "${param.result}";
		if(result != ""){
			if(result == "1"){
				alert("등록성공");
			} else {
				alert("등록실패");
			}
		}
	</script>
	
</body>
</html>