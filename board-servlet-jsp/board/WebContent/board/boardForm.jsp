<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<div class="py-1 text-center">
	<h5 class="fw-bold">게시판</h5>
</div>

<section class="container text-center">
	<div class="row w-75 m-auto justify-content-center mb-4">
		<c:choose>
			<c:when test="${not empty login}">
				<div class="mb-3 text-end">
					<a href="postCreationUI" class="btn btn-sm btn-success rounded-4" type="button">글 작성</a>
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
					<tr style="cursor: pointer" onclick="location.href='postDetailUI?boardid=${dto.boardid}'">
						<td><c:out value="${dto.boardid}" /></td>
						<td><c:out value="${dto.title}" /></td>
						<td><c:out value="${dto.name}" /></td>
						<td><c:out value="${dto.writetime}" /></td>
						<td><c:out value="${dto.viewcnt}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<ul class="pagination pagination-sm justify-content-center">
			<c:if test="${pageDTO.curPage eq 1}" >
				<li class="page-item"><a class="page-link disabled" href="#">이전</a></li>	
			</c:if>
			<c:if test="${pageDTO.curPage ne 1}" >
				<li class="page-item"><a class="page-link" href="boardUI?curPage=${pageDTO.curPage-1}">이전</a></li>	
			</c:if>
			
			<c:forEach begin="${pageDTO.startPage}" end="${pageDTO.endPage}" varStatus="status">
				<c:if test="${pageDTO.curPage eq status.index}" >
					<li class="page-item"><a class="page-link active" href="boardUI?curPage=${status.index}">${status.index}</a></li>
				</c:if>
				<c:if test="${pageDTO.curPage ne status.index}" >
					<li class="page-item"><a class="page-link" href="boardUI?curPage=${status.index}">${status.index}</a></li>
				</c:if>
			</c:forEach>
			
			<c:if test="${pageDTO.curPage eq pageDTO.totalPage}" >
				<li class="page-item"><a class="page-link disabled" href="#">다음</a></li>
			</c:if>
			<c:if test="${pageDTO.curPage ne pageDTO.totalPage}" >
				<li class="page-item"><a class="page-link" href="boardUI?curPage=${pageDTO.curPage+1}">다음</a></li>
			</c:if>
		</ul>
	</div>
</section>
