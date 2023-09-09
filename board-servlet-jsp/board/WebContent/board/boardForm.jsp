<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section class="container text-center">
	<div class="mt-5 py-3">
		<h1 class="fw-bold">게시판</h1>
	</div>
	<c:choose>
		<c:when test="${not empty login}">
			<div class="col-12 mb-3 text-end">
				<a href="boardWriteUI" class="btn btn-outline-success rounded-4 fw-bold" type="button">글 작성</a>
			</div>
		</c:when>
	</c:choose>
	<table class="table table-striped">
		<thead>
			<tr class="table-secondary">
				<th scope="col">번호</th>
				<th class="w-50" scope="col">제목</th>
				<th scope="col">작성자</th>
				<th scope="col">작성일</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${pageDTO.list}">
				<tr style="cursor: pointer" onclick="location.href='boardDetailUI?boardid=${dto.boardid}'">
					<td>${dto.boardid}</td>
					<td>${dto.title}</td>
					<td>${dto.name}</td>
					<td>${dto.writetime}</td>
					<td>${dto.viewcnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<ul class="pagination justify-content-center">
		<li class="page-item"><a class="page-link disabled" href="#">이전</a></li>
		<li class="page-item"><a class="page-link active" href="#">1</a></li>
		<li class="page-item"><a class="page-link" href="#">2</a></li>
		<li class="page-item"><a class="page-link" href="#">3</a></li>
		<li class="page-item"><a class="page-link" href="#">4</a></li>
		<li class="page-item"><a class="page-link" href="#">다음</a></li>
	</ul>
</section>
